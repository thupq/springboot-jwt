package com.service.impl;

public class MyRunnable implements Runnable {

    // Tên của Runnable, giúp chúng ta phân biệt Runnable nào đang thực thi trong Thread Pool
    private String name;

    public MyRunnable(String name) {
        // Khởi tạo Runnable với biến name truyền vào
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " đang thực thi...");

        // Giả lập thời gian chạy của Runnable mất 2 giây
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " kết thúc.");
    }

}