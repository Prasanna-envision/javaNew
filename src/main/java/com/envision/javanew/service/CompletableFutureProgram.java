package com.envision.javanew.service;

import com.envision.javanew.component.emp;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CompletableFutureProgram {

    public Void saveEmployees(File jsonFile) throws ExecutionException, InterruptedException {
        ObjectMapper objectMapper= new ObjectMapper();
        Executor executor=Executors.newFixedThreadPool(5);
        CompletableFuture<Void> completableFuture=CompletableFuture.runAsync(()->{
            try {
                List<emp> emps=objectMapper.readValue(jsonFile,new TypeReference<List<emp>>(){

                 });
                System.out.println("Thread : " + Thread.currentThread().getName());
                System.out.println(emps.size());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        },executor);
        return completableFuture.get();


    }
    public List<emp> savesupplyEmployees(File jsonFile) throws ExecutionException, InterruptedException {
        ObjectMapper objectMapper= new ObjectMapper();
        Executor executor=Executors.newCachedThreadPool();
        CompletableFuture<List<emp>> completableFuture=CompletableFuture.supplyAsync(()->{
            try {
                List<emp> emps=objectMapper.readValue(jsonFile,new TypeReference<List<emp>>(){

                });
                System.out.println("Thread : " + Thread.currentThread().getName());
                System.out.println(emps.size());
                return emps;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        },executor);
        return completableFuture.get();


    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureProgram runAsyncDemo = new CompletableFutureProgram();
        runAsyncDemo.saveEmployees(new File("employ.json"));
        //runAsyncDemo.saveEmployeesWithCustomExecutor(new File("employees.json"));

    }
}
