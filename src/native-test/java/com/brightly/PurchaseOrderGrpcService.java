package com.brightly;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;

@GrpcService
public class PurchaseOrderGrpcService implements  PurchaseOrderGrpc {
    @Override
    public Uni<POReply> createPO(PORequest request) {
        return Uni.createFrom().item(request.getNumber())
                .map(id -> POReply.newBuilder().setPoId(id).build());
    }
}
