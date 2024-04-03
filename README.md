# :pushpin: goQuality
> 버스 전세 시스템을 이용한 전자상거래

</br>

## 1. 제작 기간 & 참여 인원
- 2024년 3월 18일 ~ 4월 2일
- 5인 (박준범, 이병헌, 오인영, 정규원, 김상원)

</br>

## 2. 사용 기술
#### `Back-end`
  - Java
    
#### `Front-end`
  - Html
  - css
  - Js
    
#### `IDE`
  - Eclipse
  - Visual Studio Code
    
#### `Server`
  - Apache Tomcat

</br>

## 3. ERD 설계
![](https://github.com/2024-SMHRD-KDT-BigData-23/BooksProject/blob/master/BooksProject/src/main/webapp/img/ERD.jpg)


## 4. 핵심 기능
이 서비스의 핵심 기능은 콘서트를 확인 후 버스현황을 파악하고 전세버스의 좌석현황 및 예약기능입니다.</br>
사용자는 콘서트를 예매하고 다른 지역으로 가고자 할 때 전세버스의 좌석현황을 보고 자신이 원하는 자리를 예약하면 됩니다.</br>
기능의 상세한 설명은 다음에 준비되어있습니다.</br>

<details>
<summary><b>핵심 기능 설명 펼치기</b></summary>
<div markdown="1">

### 4.1. 전체 흐름
![](https://github.com/2024-SMHRD-KDT-BigData-23/BooksProject/blob/master/BooksProject/src/main/webapp/img/main.jpg)

### 4.2. Frontcontroller
![](https://github.com/2024-SMHRD-KDT-BigData-23/BooksProject/blob/master/BooksProject/src/main/webapp/img/Frontcontroller.jpg)

- **페이지 이동** :pushpin: [코드 확인](https://github.com/2024-SMHRD-KDT-BigData-23/BooksProject/blob/master/BooksProject/src/main/java/com/smhrd/frontcontroller/FrontController.java)
  - 사용자의 페이지 이동 요청이 들어올 때마다 Frontcontroller로 이동하게됩니다.
  - init기능을 사용하여 각 controller가 실행된 후 반환 값을 가지고 다시 Frontcontroller로 이동하게 되며, 반환값.jsp로 이동하는 것으로 사용자의 요청에 응답해줍니다.


### 4.3. Data

![](https://github.com/2024-SMHRD-KDT-BigData-23/BooksProject/blob/master/BooksProject/src/main/webapp/img/Getdata.jpg)

- **eventList** :pushpin: [코드 확인](https://github.com/2024-SMHRD-KDT-BigData-23/BooksProject/blob/master/BooksProject/src/main/java/com/smhrd/controller/eventList.java)
- **mainEventlist** :pushpin: [코드 확인](https://github.com/2024-SMHRD-KDT-BigData-23/BooksProject/blob/master/BooksProject/src/main/java/com/smhrd/controller/mainEventlist.java)
- **progressBar** :pushpin: [코드 확인](https://github.com/2024-SMHRD-KDT-BigData-23/BooksProject/blob/master/BooksProject/src/main/java/com/smhrd/controller/progressBar.java)
- **bookingList** :pushpin: [코드 확인](https://github.com/2024-SMHRD-KDT-BigData-23/BooksProject/blob/master/BooksProject/src/main/java/com/smhrd/controller/bookingList.java)</br>

  - Frontcontroller의 요청을 받은 Controller에서는 DAO에 접근하여 mappers 안의 mysql쿼리문을 데이터베이스에서 실행시켜 얻은 데이터를 DAO로 반환받아 controller에게 넘겨준다.</br>
- **DAO** :pushpin: [코드 확인](https://github.com/2024-SMHRD-KDT-BigData-23/BooksProject/blob/master/BooksProject/src/main/java/com/smhrd/database/DAO.java)
- **BooksMapper** :pushpin: [코드 확인](https://github.com/2024-SMHRD-KDT-BigData-23/BooksProject/blob/master/BooksProject/src/main/java/com/smhrd/database/BooksMapper.xml)</br>
</div>
</details>


</br>

## 5. 핵심 트러블 슈팅
### 5.1. 컨텐츠 필터와 페이징 처리 문제
- 저는 이 서비스가 페이스북이나 인스타그램 처럼 가볍게, 자주 사용되길 바라는 마음으로 개발했습니다.  
때문에 페이징 처리도 무한 스크롤을 적용했습니다.

- 하지만 [무한스크롤, 페이징 혹은 “더보기” 버튼? 어떤 걸 써야할까](https://cyberx.tistory.com/82) 라는 글을 읽고 무한 스크롤의 단점들을 알게 되었고,  
다양한 기준(카테고리, 사용자, 등록일, 인기도)의 게시물 필터 기능을 넣어서 이를 보완하고자 했습니다.

- 그런데 게시물이 필터링 된 상태에서 무한 스크롤이 동작하면,  
필터링 된 게시물들만 DB에 요청해야 하기 때문에 아래의 **기존 코드** 처럼 각 필터별로 다른 Query를 날려야 했습니다.

<details>
<summary><b>기존 코드</b></summary>
<div markdown="1">

~~~java
/**
 * 게시물 Top10 (기준: 댓글 수 + 좋아요 수)
 * @return 인기순 상위 10개 게시물
 */
public Page<PostResponseDto> listTopTen() {

    PageRequest pageRequest = PageRequest.of(0, 10, Sort.Direction.DESC, "rankPoint", "likeCnt");
    return postRepository.findAll(pageRequest).map(PostResponseDto::new);
}

/**
 * 게시물 필터 (Tag Name)
 * @param tagName 게시물 박스에서 클릭한 태그 이름
 * @param pageable 페이징 처리를 위한 객체
 * @return 해당 태그가 포함된 게시물 목록
 */
public Page<PostResponseDto> listFilteredByTagName(String tagName, Pageable pageable) {

    return postRepository.findAllByTagName(tagName, pageable).map(PostResponseDto::new);
}

// ... 게시물 필터 (Member) 생략 

/**
 * 게시물 필터 (Date)
 * @param createdDate 게시물 박스에서 클릭한 날짜
 * @return 해당 날짜에 등록된 게시물 목록
 */
public List<PostResponseDto> listFilteredByDate(String createdDate) {

    // 등록일 00시부터 24시까지
    LocalDateTime start = LocalDateTime.of(LocalDate.parse(createdDate), LocalTime.MIN);
    LocalDateTime end = LocalDateTime.of(LocalDate.parse(createdDate), LocalTime.MAX);

    return postRepository
                    .findAllByCreatedAtBetween(start, end)
                    .stream()
                    .map(PostResponseDto::new)
                    .collect(Collectors.toList());
    }
~~~

</div>
</details>

- 이 때 카테고리(tag)로 게시물을 필터링 하는 경우,  
각 게시물은 최대 3개까지의 카테고리(tag)를 가질 수 있어 해당 카테고리를 포함하는 모든 게시물을 질의해야 했기 때문에  
- 아래 **개선된 코드**와 같이 QueryDSL을 사용하여 다소 복잡한 Query를 작성하면서도 페이징 처리를 할 수 있었습니다.

<details>
<summary><b>개선된 코드</b></summary>
<div markdown="1">

~~~java
/**
 * 게시물 필터 (Tag Name)
 */
@Override
public Page<Post> findAllByTagName(String tagName, Pageable pageable) {

    QueryResults<Post> results = queryFactory
            .selectFrom(post)
            .innerJoin(postTag)
                .on(post.idx.eq(postTag.post.idx))
            .innerJoin(tag)
                .on(tag.idx.eq(postTag.tag.idx))
            .where(tag.name.eq(tagName))
            .orderBy(post.idx.desc())
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
            .fetchResults();

    return new PageImpl<>(results.getResults(), pageable, results.getTotal());
}
~~~

</div>
</details>

</br>



## 6. 팀원 소개
>프로젝트 개발 회고 글: https://zuminternet.github.io/ZUM-Pilot-integer/
