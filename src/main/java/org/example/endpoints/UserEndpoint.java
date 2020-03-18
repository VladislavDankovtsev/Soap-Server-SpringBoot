package org.example.endpoints;


import com.techprimers.spring_boot_soap_example.GetUserRequest;
import com.techprimers.spring_boot_soap_example.GetUserResponse;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Map;

@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://techprimers.com/spring-boot-soap-example";

    private UserRepository userRepository;

    @Autowired
    public UserEndpoint(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser (@RequestPayload GetUserRequest request){
        GetUserResponse response  = new GetUserResponse();
        System.out.println("id "+request.getId());
        response.setUser(userRepository.findUser(request.getId()));
        System.out.println("Response: "+response.getUser().getName());
        return response;
    }
    /*@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getListUserResponse")
    @ResponsePayload
    public GetListUserResponse getlistUser (@RequestPayload GetUserRequest request){
        GetListUserResponse response  = new GetListUserResponse();
        System.out.println("id "+request.getId());
        response.getUser();
        //response.set(userRepository.userList());
        return response;
    }*/

}
