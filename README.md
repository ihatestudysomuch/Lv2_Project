# 낚시성 뉴스 탐지 서비스 
- 낚시성(가짜) 뉴스의 여부를 판단해주는 서비스를 제공합니다. deep learning, 관련 data 가상으로 있다고 가정하게 작성했습니다.
- 국내의 정치, 경제, 사회, 연예 .. 많은 낚시성 뉴스로 언론의 신뢰 하락과 렉카들의 등장으로 많은 사람들이 피해를 입고있음에 
직접 사용자가 뉴스 기사를 판별 할 수 있고 많은 사람들과 이에 대해 얘기 할 수 있도록 service 제공  

## Event Storming
www.msaez.io/#/149322864/storming/fakenewsdetectionservice

## Before Running Services
### Kafka server run
```
cd infra
docker-compose up
```
- Kafka message 확인:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```
- curl /  httpie 설치 

## Event Storming 개요
- news
- analyse
- detect
- board
- comment
- notify
- mypage
- blue sticker(Command): 동기 호출, frontend에서 button처럼 사용자의 상호작용으로 이후 Event 동작, Controller
- liac sticker(Policy): 비동기 호출, 사용자의 상호작용이 아닌, Event를 받아 곧장 실행, PolicyHandler

## Run API Gateway (Spring Gateway), 필수 x
```
cd gateway
mvn spring-boot:run
```

## Test by API
### news
- news는 뉴스의 낚시성 여부를 판별하기 위해 뉴스를 등록하는 것 service
```
 http :8082/newsTitle="newsTitle" newsSubTitle="newsSubTitle" newsContent="newsContent" status="status" user="user" 
```

### analyse
- analyse는 NewsUploaded, RetryUploaded Event를 받아 analyse 비동기 호출로 업로드한 news를 분석, 진행 %를 알려주는 service
```
 http :8086/analyses id="id" newsId="newsId" status="status" newsTitle="newsTitle" newsSubTitle="newsSubTitle" newsContent="newsContent" progress="progress" user="user" 
```

### detect
- detect는 analyse service를 끝마친(AnalsisCompleted Event) 후, 최종 낚시성 확률, 결과를 알려주는 service
```
 http :8085/detections newsId="newsId" ratio="ratio" status="status" result="result" newsTitle="newsTitle" newsSubTitle="newsSubTitle" newsContent="newsContent" user="user" 
```


### board
- board는 DetectionSucceeded Event를 끝마쳐 register 비동기 호출을 받아 판독이 끝난 뉴스를 게시판에 게시글을 올리고 관리하는 service
```
 http :8083/boards id="id" newsId="newsId" newsTitle="newsTitle" newsSubTitle="newsSubTitle" newsContent="newsContent" status="status" commentCount="commentCount" likeCount="likeCount" badCount="badCount" result="result" ratio="ratio" user="user" 
```

### comment
- comment는 게시판에 올라온 게시글에 댓글을 달 수 있는 service
```
 http :8084/comments id="id" user="user" commentContent="commentContent" boardId="boardId" likeCount="likeCount" badCount="badCount" 
```

### mypage
- CQRS service
```
 http: 8087/mypages
```
### notify
- notify는 뉴스 업로드 ~ 댓글까지 사용자의 이용 현황 조회 (삭제 해거나 다른 용도로 개선 요망, gateway와 포트도 겹침)
```
 http :8088/notifications id="id" status="status" 
```

## 기타
- Lv2를 배울 당시 연습을 하며 만들었던 것이라 세부 사항, 오타, 코드 작성에 부족함이 많음(이미 시간이 지났기 때문에 수정하고 제출하는 것도 아니라고 생각합니다!)
- frontend x
- 팀 경진대회에서 팀과 소통하여 피드백을 받고 cloud native한 app을 만들 수 있도록 나아갈 것

