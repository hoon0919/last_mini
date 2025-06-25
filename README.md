# 

## Model
www.msaez.io/#/204953303/storming/mini

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

- SubscriberMembership
- ContentManagement
- PaymentSubscription
- AIPublishing
- AuthorManagement
- BookManagement


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- SubscriberMembership
```
 http :8088/subscribers subscriberId="subscriberId"name="name"phoneNumber="phoneNumber"ktVerified="ktVerified"pointBalance="pointBalance"
 http :8088/pointTransactions transactionId="transactionId"subscriberId="subscriberId"amount="amount"createdAt="createdAt"
```
- ContentManagement
```
 http :8088/manuscripts manuscriptId="manuscriptId"title="title"content="content"createdAt="createdAt"updatedAt="updatedAt"
 http :8088/publicationHistories publicationHistoryId="publicationHistoryId"requestedAt="requestedAt"resultMessage="resultMessage"publishedAt="publishedAt"
```
- PaymentSubscription
```
 http :8088/subscriptions subscriptionId="subscriptionId"startDate="startDate"endDate="endDate"
 http :8088/payments paymentId="paymentId"subscriberId="subscriberId"amount="amount"timestamp="timestamp"
```
- AIPublishing
```
 http :8088/publishingJobs publishingJobId="publishingJobId"contentId="contentId"coverImageUrl="coverImageUrl"summaryText="summaryText"productId="productId"requestedAt="requestedAt"completedAt="completedAt"
 http :8088/bookProducts productId="productId"registrationDate="registrationDate"
```
- AuthorManagement
```
 http :8088/authors authorId="authorId"name="name"email="email"registeredAt="registeredAt"approvedAt="approvedAt"rejectedAt="rejectedAt"
 http :8088/authorApprovals approvalId="approvalId"decidedAt="decidedAt"decidedBy="decidedBy"reason="reason"
```
- BookManagement
```
 http :8088/books bookId="bookId"title="title"reportedReason="reportedReason"createdAt="createdAt"
 http :8088/bookReports reportId="reportId"reporterId="reporterId"reason="reason"reportedAt="reportedAt"
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
