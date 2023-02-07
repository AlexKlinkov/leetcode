class Foo {
    
    private int numberOfThread;

    public Foo() {
        this.numberOfThread = 1;
    }

    synchronized  public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        while(this.numberOfThread != 1) {
            wait();
        }
        printFirst.run();
        this.numberOfThread++;
        notifyAll();
    }

    synchronized public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        while(this.numberOfThread != 2) {
            wait();
        }
        printSecond.run();
        this.numberOfThread++;
        notifyAll();
    }

    synchronized public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        while(this.numberOfThread != 3) {
            wait();
        }
        printThird.run();
        this.numberOfThread++;
        notifyAll();
    }
}