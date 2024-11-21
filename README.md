# 

## Model
www.msaez.io/#/149322864/storming/fakenewsdetectionservice

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- news
- board
- comment
- detect
- analyse
- mypage
- notify


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- news
```
 http :8088/news id="id" newsTitle="newsTitle" newsSubTitle="newsSubTitle" newsContent="newsContent" status="status" user="user" 
```
- board
```
 http :8088/boards id="id" newsId="newsId" newsTitle="newsTitle" newsSubTitle="newsSubTitle" newsContent="newsContent" status="status" commentCount="commentCount" likeCount="likeCount" badCount="badCount" result="result" ratio="ratio" user="user" 
```
- comment
```
 http :8088/comments id="id" user="user" commentContent="commentContent" boardId="boardId" likeCount="likeCount" badCount="badCount" 
```
- detect
```
 http :8088/detections id="id" newsId="newsId" ratio="ratio" status="status" result="result" newsTitle="newsTitle" newsSubTitle="newsSubTitle" newsContent="newsContent" user="user" 
```
- analyse
```
 http :8088/analyses id="id" newsId="newsId" status="status" newsTitle="newsTitle" newsSubTitle="newsSubTitle" newsContent="newsContent" progress="progress" user="user" 
```
- mypage
```
```
- notify
```
 http :8088/notifications id="id" status="status" 
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

