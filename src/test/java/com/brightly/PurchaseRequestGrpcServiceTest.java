//package com.brightly;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//
//import java.time.Duration;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import io.quarkus.grpc.GrpcClient;
//import io.quarkus.test.junit.QuarkusTest;
//
//import javax.enterprise.context.BeforeDestroyed;
//
//@QuarkusTest
//public class PurchaseRequestGrpcServiceTest {
//
//	@GrpcClient
//	PurchaseOrderGrpc purchaseOrderGrpc;
//
//	PORequest poRequest;
//
//	@BeforeEach
//	public void setup(){
//		poRequest = PORequest.newBuilder().setNumber("1234L").setAccountNumber("Brightly").setCreatedBy("ABCD").build();
//	}
//
//	@Test
//	public void testCreatePO() {
//
//		long testReply = 1234L;
//		POReply poReply = purchaseOrderGrpc.createPO(poRequest).await().atMost(Duration.ofSeconds(5));
//		Assertions.assertNotEquals(0l, poReply.getPoId());
//	}
//}
