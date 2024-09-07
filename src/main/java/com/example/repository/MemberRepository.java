package com.example.repository;

import com.example.dto.MemberDTO;
import com.example.entity.Member;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface MemberRepository extends ReactiveMongoRepository<Member, String> {

    @Query("{ 'id' : ?0 }")
    @Update("{ $set: { 'name' : ?1 } }")
    Mono<Long> updateName(String id, String name);

    @Query(value = "{}", sort = "{ 'createdAt' : -1 }")
    Flux<MemberDTO.Item> findAllByPage(Pageable pageable);

    /*
    // 조인예제
    @Aggregation(pipeline = {
            "{ $match: { 'id': ?0 }}",
            "{ $lookup: { from: 'member', localField: 'member._id', foreignField: '_id', as: 'member_info' }}",
            "{ $unwind: '$member_info' }"
    })
    Mono<BoardDocument> findAllWithMemberInfo(String id);

    // 조인 페이징 예제
    @Aggregation(pipeline = {
            "{ $sort : { 'created_ts' : -1 } }",
            "{ $skip : ?0 }",
            "{ $limit : ?1 }"
            "{ $lookup: { from: 'member', localField: 'member._id', foreignField: '_id', as: 'member_info' }}",
            "{ $unwind: '$member_info' }"
    })
    Flux<BoardDocument> findAllByPage(Integer offset, Integer limit);
    */
}