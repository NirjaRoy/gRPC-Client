package com.roy.grpcClient.clientClass;
import com.roy.grpcClient.User.APIResponse;
import com.roy.grpcClient.User.LoginRequest;
import com.roy.grpcClient.userGrpc;
import com.roy.grpcClient.userGrpc.userBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
public class GrpcClient {

	public static void main(String[] args) {
		//Builder class for channel that can comm with grpc server & then talk to APIs	
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7134).usePlaintext().build();
		//Generate stubs from proto file
		userBlockingStub userStub = userGrpc.newBlockingStub(channel);
		//construct builder (for constructing object in Grpc)
		LoginRequest loginrequest = LoginRequest.newBuilder().setUsername("RAM").setPassword("RAM").build();
		APIResponse response = userStub.login(loginrequest);
		
		System.out.println(response.getResponsemessage());

	}
}
