<template>
  <v-container fluid>
    <v-row>
      <v-card
          v-for="(card, index) in cards"
          :key="index"
          class="mx-auto"
          style="height:300px; width:300px; margin-bottom:20px;"
          outlined
      >
        <v-list-item>
          <v-icon style="margin-top: 30%; margin-left: 37.5%;" color="primary" size="64">mdi-apps</v-icon>
        </v-list-item>
        <v-card-actions>
          <v-btn
              class="mx-auto"
              outlined
              rounded
              :to="card.link"
              style="font-weight:500; font-size:20px; border:solid 2px; max-width:250px; overflow:hidden; margin-top: 10%;"
          >
              {{ card.text }}
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'Index',
  data: () => ({
    cards: [
      {
          text: "구독자",
          link: "/subscribers",
      },
      {
          text: "포인트 트랜잭션",
          link: "/pointTransactions",
      },
      {
          text: "회원 상세 정보",
          link: "/subscriberDetails",
      },
      {
          text: "포인트 거래 내역",
          link: "/pointTransactionHistories",
      },
      {
          text: "포인트 부족 안내",
          link: "/pointExhaustedAlerts",
      },
      {
          text: "원고",
          link: "/manuscripts",
      },
      {
          text: "출간 이력",
          link: "/publicationHistories",
      },
      {
          text: "출간 결과 확인",
          link: "/publishingStatuses",
      },
      {
          text: "나의 글 목록",
          link: "/manuscriptLists",
      },
      {
          text: "글 상세 정보",
          link: "/manuscriptDetails",
      },
      {
          text: "출간 이력 목록",
          link: "/publicationHistoryLists",
      },
      {
          text: "출간 이력 상세",
          link: "/publicationHistoryDetails",
      },
      {
          text: "구독",
          link: "/subscriptions",
      },
      {
          text: "결제",
          link: "/payments",
      },
      {
          text: "구독 상세 정보",
          link: "/subscriptionDetails",
      },
      {
          text: "구독 목록",
          link: "/subscriptionLists",
      },
      {
          text: "결제 내역 조회",
          link: "/paymentHistories",
      },
      {
          text: "결제 상세 조회",
          link: "/paymentDetails",
      },
      {
          text: "출판 작업",
          link: "/publishingJobs",
      },
      {
          text: "상품 정보",
          link: "/bookProducts",
      },
      {
          text: "출간 처리 현황 목록",
          link: "/publishingJobStatusLists",
      },
      {
          text: "출간 처리 상세 정보",
          link: "/publishingJobDetails",
      },
      {
          text: "전자책 상품 목록",
          link: "/bookProductLists",
      },
      {
          text: "전자책 상품 상세",
          link: "/bookProductDetails",
      },
      {
          text: "작가",
          link: "/authors",
      },
      {
          text: "작가 승인 처리",
          link: "/authorApprovals",
      },
      {
          text: "작가 등록 상세 정보",
          link: "/authorRegistrationDetails",
      },
      {
          text: "작가 등록 신청 목록",
          link: "/authorRegistrationLists",
      },
      {
          text: "작가 승인/거절 상세",
          link: "/authorApprovalDetails",
      },
      {
          text: "작가 승인/거절 내역 목록",
          link: "/authorApprovalLists",
      },
      {
          text: "서적",
          link: "/books",
      },
      {
          text: "서적 신고",
          link: "/bookReports",
      },
      {
          text: "서적 관리 상세",
          link: "/bookAdminDetails",
      },
      {
          text: "서적 관리 목록",
          link: "/bookAdminLists",
      },
      {
          text: "서적 신고 상세",
          link: "/bookReportDetails",
      },
      {
          text: "서적 신고 목록",
          link: "/bookReportLists",
      },
    ],
  }),
};
</script>
