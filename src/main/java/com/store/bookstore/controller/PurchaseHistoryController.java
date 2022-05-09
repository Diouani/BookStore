package com.store.bookstore.controller;


import com.store.bookstore.model.PurchaseHistory;
import com.store.bookstore.security.UserPrincipal;
import com.store.bookstore.service.IPurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/purchase-history")
public class PurchaseHistoryController {

    @Autowired
    private IPurchaseHistoryService purchaseHistoryService;

    @PostMapping
    public ResponseEntity<?> savePurchaseHistory(@RequestBody PurchaseHistory purchaseHistory){


        return new ResponseEntity<>( purchaseHistoryService.savePurchaseHistory(purchaseHistory),HttpStatus.CREATED);
    }



    @GetMapping
    public ResponseEntity<?> getAllPurchasesOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return  ResponseEntity.ok(purchaseHistoryService.findPurchasedHistoryItemOfUser(userPrincipal.getId()));
    }



}
