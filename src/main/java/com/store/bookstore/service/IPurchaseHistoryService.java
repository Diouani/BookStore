package com.store.bookstore.service;

import com.store.bookstore.model.PurchaseHistory;
import com.store.bookstore.repository.projection.IPurchaseItem;

import java.util.List;

public interface IPurchaseHistoryService {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<IPurchaseItem> findPurchasedHistoryItemOfUser(Long userId);
}
