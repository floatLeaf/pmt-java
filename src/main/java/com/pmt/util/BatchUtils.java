package com.pmt.util;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class BatchUtils {
//    @Autowired
//    @Qualifier("PackageAndResourceServiceThreadPool")
//    private ExecutorService executorService;
//
//    public <T, R> List<R> getListBatch(List<T> list, Integer pageSize, Function<List<T>, List<R>> func){
//        if (CollectionUtils.isEmpty(list))
//            return Collections.emptyList();
//        if (pageSize == null || pageSize == 0)
//            pageSize = 20;
//        List<R> result = Lists.newLinkedList();
//        //队列
//        LinkedBlockingQueue<Future<List<R>>> futures = new LinkedBlockingQueue<>();
//        //页数 向上取整
//        Double pageCount = Math.ceil(Double.valueOf(list.size()) / pageSize);
//        for (int i = 0; i < pageCount; i++) {
//            List<T> subList = list.stream().skip(i * pageSize).limit(pageSize).collect(Collectors.toList());
//            //线程池
//            Future<List<R>> subFutureTask = executorService.submit(() -> func.apply(subList));
//            futures.add(subFutureTask);
//            i++;
//        }
//        futures.forEach(s -> {
//            List<R> rs = Collections.emptyList();
//            try {
//                rs = s.get(5, TimeUnit.SECONDS);
//
//            } catch (InterruptedException e) {
////                logger.error(this.getClass().getSimpleName().toLowerCase() + ":interrupted", JSON.toJSONString(rs) + JSON.toJSONString(s));
//            } catch (ExecutionException e) {
////                logger.error(this.getClass().getSimpleName().toLowerCase() + ":error", JSON.toJSONString(rs) + JSON.toJSONString(s));
//            } catch (TimeoutException e) {
////                logger.error(this.getClass().getSimpleName().toLowerCase() + ":timeout", JSON.toJSONString(rs) + JSON.toJSONString(s));
//            }
//            result.addAll(rs);
//        });
//        return result;
//
//    }
}


//    //并发+批量调用
//    public List<PackageInfoType> getPackageInfoBatch(List<Long> packageIdList, ClientRequestDO clientRequest) {
//        if (CollectionUtils.isEmpty(packageIdList))
//            return Collections.emptyList();
//        //function分页调用
//        List<PackageInfoType> listBatch = batchUtils.getListBatch(packageIdList, pageSize, (t) -> {
//            //构建微服务请求参数
//            GetPackageInfoRequestType subRequest = new GetPackageInfoRequestType();
//            subRequest.setPackageIdList(t);
//            subRequest.setRequestBaseData(buildQueryRequestBaseData(clientRequest, null));
//            try {
//                //具体调用微服务
//                GetPackageInfoResponseType packageInfo = newProductAPIServiceProxy.getPackageInfo(subRequest);
//                if (packageInfo == null || CollectionUtils.isEmpty(packageInfo.getPackageInfoList()))
//                    return Collections.emptyList();
//                return packageInfo.getPackageInfoList();
//            } catch (Exception e) {
//                logger.error(e);
//            }
//            return Collections.emptyList();
//        });
//        List<PackageInfoType> result = Lists.newLinkedList();
//        //排序
//        packageIdList.stream().forEach(s -> {
//            Optional<PackageInfoType> first = listBatch.stream().filter(lb -> s.equals(lb.getPackageId())).findFirst();
//            if (first.isPresent())
//                result.add(first.get());
//        });
//        return result;
//    }
//
//
//
//    //具体业务逻辑（线程池调用）
//    CompletableFuture<List<PackageInfoType>> packageFuture = CompletableFuture.supplyAsync(() -> openApiService.getPackageInfoBatch(packageIdList, clientRequest), executorService);
//    List<PackageInfoType> packageInfoBatch = packageFuture.get();
//}
