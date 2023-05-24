import java.util.Random;
import java.util.Scanner;

enum DumplingType {
    PORK,
    BEEF,
    VEGGIE
}

class Dumpling {
    private int porkQuantity;
    private int beefQuantity;
    private int veggieQuantity;
    private boolean soldOut;

    public Dumpling(int porkQuantity, int beefQuantity, int veggieQuantity) {
        this.porkQuantity = porkQuantity;
        this.beefQuantity = beefQuantity;
        this.veggieQuantity = veggieQuantity;
        this.soldOut = false;
    }

    public synchronized void sell(DumplingType type, int quantityToSell) {
        if (soldOut) {
            System.out.println("水饺已售完");
            return;
        }
        switch (type) {
            case PORK:
                if (porkQuantity >= quantityToSell) {
                    System.out.println(Thread.currentThread().getName() + " 買了 " + quantityToSell + " 个猪肉水饺");
                    porkQuantity -= quantityToSell;
                } else {
                    System.out.println(Thread.currentThread().getName() + " 猪肉水饺库存不足，无法购买 " + quantityToSell + " 个");
                }
                break;
            case BEEF:
                if (beefQuantity >= quantityToSell) {
                    System.out.println(Thread.currentThread().getName() + " 购买了 " + quantityToSell + " 个牛肉水饺");
                    beefQuantity -= quantityToSell;
                } else {
                    System.out.println(Thread.currentThread().getName() + " 牛肉水饺库存不足，无法购买 " + quantityToSell + " 个");
                }
                break;
            case VEGGIE:
                if (veggieQuantity >= quantityToSell) {
                    System.out.println(Thread.currentThread().getName() + " 购买了 " + quantityToSell + " 个蔬菜水饺");
                    veggieQuantity -= quantityToSell;
                } else {
                    System.out.println(Thread.currentThread().getName() + " 蔬菜水饺库存不足，无法购买 " + quantityToSell + " 个");
                }
                break;
        }

        if (porkQuantity <= 0 && beefQuantity <= 0 && veggieQuantity <= 0) {
            soldOut = true;
            System.out.println("水饺已售完");
        }
    }

    public synchronized int getPorkQuantity() {
        return porkQuantity;
    }

    public synchronized int getBeefQuantity() {
        return beefQuantity;
    }

    public synchronized int getVeggieQuantity() {
        return veggieQuantity;
    }

    public synchronized boolean isSoldOut() {
        return soldOut;
    }
}

class DumplingSeller implements Runnable {
    private String name;
    private Dumpling dumpling;
    private int maxQuantityToSell;
    private int maxCustomers;

    public DumplingSeller(String name, Dumpling dumpling, int maxQuantityToSell) {
        this.name = name;
        this.dumpling = dumpling;
        this.maxQuantityToSell = maxQuantityToSell;
        this.maxCustomers = dumpling.getPorkQuantity() / maxQuantityToSell;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (!dumpling.isSoldOut() && maxCustomers > 0) {
            synchronized (dumpling) {
                int customers = Math.min(maxCustomers, maxQuantityToSell);
                DumplingType type = getRandomDumplingType(); // 随机选择水饺种类
                int quantityToSell = random.nextInt(41) + 10; // 生成10到50之间的随机数，表示每位顾客本次点饺的数量

                if (type == DumplingType.PORK) {
                    if (quantityToSell <= customers) {
                        dumpling.sell(DumplingType.PORK, quantityToSell);
                    } else {
                        dumpling.sell(DumplingType.PORK, customers);
                    }
                } else if (type == DumplingType.BEEF) {
                    if (quantityToSell <= customers) {
                        dumpling.sell(DumplingType.BEEF, quantityToSell);
                    } else {
                        dumpling.sell(DumplingType.BEEF, customers);
                    }
                } else if (type == DumplingType.VEGGIE) {
                    if (quantityToSell <= customers) {
                        dumpling.sell(DumplingType.VEGGIE, quantityToSell);
                    } else {
                        dumpling.sell(DumplingType.VEGGIE, customers);
                    }
                }
            }
            try {
                Thread.sleep(1000); // 模拟售卖过程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(3000); // 模拟等待服务生的时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private DumplingType getRandomDumplingType() {
        Random random = new Random();
        int randomNum = random.nextInt(3);
        switch (randomNum) {
            case 0:
                return DumplingType.PORK;
            case 1:
                return DumplingType.BEEF;
            case 2:
                return DumplingType.VEGGIE;
            default:
                return DumplingType.PORK;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入同时光顾的顾客数目：");
        int numCustomers = scanner.nextInt();

        Dumpling dumpling = new Dumpling(5000, 3000, 1000);
        Thread[] threads = new Thread[numCustomers];
        for (int i = 0; i < numCustomers; i++) {
            threads[i] = new Thread(new DumplingSeller("Seller " + (i + 1), dumpling, 50));
            threads[i].start();
        }

        try {
            for (int i = 0; i < numCustomers; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}