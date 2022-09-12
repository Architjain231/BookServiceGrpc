//package com.brightly.service;
//
//import io.quarkus.test.junit.QuarkusTest;
//import io.quarkus.test.junit.mockito.InjectMock;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import javax.inject.Inject;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@QuarkusTest
//class LineItemServiceImplTest {
//
//    @Inject
//    private LineItemService gLineItemService;
//
//    @InjectMock
//    private LineItemRepository gLineItemRepo;
//
//    @Test
//    void getLineItemsByIds() {
//        LineItem vItem = new LineItem();
//        vItem.setSupplier("DELL");
//        vItem.setSkuId(1l);
//        List<LineItem> vList = Arrays.asList(vItem);
//        Mockito.when(gLineItemRepo.list("id", Arrays.asList(1l))).thenReturn(vList);
//        assertEquals(vList.size(), gLineItemService.getLineItemsByIds(Arrays.asList(1l)).size());
//    }
//}