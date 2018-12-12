package com.service.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * comment GlobalFilter对所有路由起作用
 *
 * @author 破冰
 * @review 破冰
 * @date: 2018-11-29 15:24
 */
@Component
@Slf4j
public class MyFilter implements GatewayFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        Flux<DataBuffer> body = request.getBody();

//        Object cachedRequestBody = exchange.getAttribute("cachedRequestBodyObject");
//        log.info("cachedRequestBody:{}", cachedRequestBody);
        StringBuilder sb = new StringBuilder();
        body.subscribe(buffer -> {
            byte[] bytes = new byte[buffer.readableByteCount()];
            buffer.read(bytes);
            DataBufferUtils.release(buffer);
            String bodyString = new String(bytes, StandardCharsets.UTF_8);
            sb.append(bodyString);
        });
        log.info("originalBody:{}", sb.toString());

        // 增加一个参数
        Map<String, Object> map = JSONObject.parseObject(sb.toString());    //json对象转Map
        map.put("birth", "199303");
        String jsonString = JSON.toJSONString(map);
        log.info("newBody:{}", jsonString);
//        DataBuffer bodyDataBuffer = stringBuffer(jsonString);
//        DataBuffer bodyDataBuffer = stringBuffer(sb.toString());
        String str = "{\"username\": \"iphone6\",\"age\": \"28\"}";
        log.info("str:{}", str);

        // TODO 这里修改sb的内容会导致json解析失败，暂时解决不了
        DataBuffer bodyDataBuffer = stringBuffer(sb.toString());
        Flux<DataBuffer> bodyFlux = Flux.just(bodyDataBuffer);
        request = new ServerHttpRequestDecorator(request) {
            @Override
            public Flux<DataBuffer> getBody() {
                return bodyFlux;
            }
        };
        return chain.filter(exchange.mutate().request(request).build());
    }

    @Override
    public int getOrder() {
        return 1;
    }

    private DataBuffer stringBuffer(String value) {
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);

        NettyDataBufferFactory nettyDataBufferFactory = new NettyDataBufferFactory(ByteBufAllocator.DEFAULT);
        DataBuffer buffer = nettyDataBufferFactory.allocateBuffer(bytes.length);
        buffer.write(bytes);
        return buffer;
    }

}
