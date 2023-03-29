package exception;

public class MyException extends Exception {
    private int num;

    public MyException(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public static void main(String[] args) {
        try {
            getMoney(500); // 想提領 500 元
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getMoney(int money) throws MyException {
        // 假設資料庫只剩 200
        if (200 - money < 0) {
            throw new MyException(-1);
        }
        return money;
    }

}
