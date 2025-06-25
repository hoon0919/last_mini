<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: '구독자/회원 관리' }" />
        <VerticalNavLink
            :item="{
                title: '구독자',
                to: '/subscribers',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '포인트 트랜잭션',
                to: '/pointTransactions',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '회원 상세 정보',
                to: '/subscriberDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '포인트 거래 내역',
                to: '/pointTransactionHistories',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '포인트 부족 안내',
                to: '/pointExhaustedAlerts',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '콘텐츠 관리' }" />
        <VerticalNavLink
            :item="{
                title: '원고',
                to: '/manuscripts',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '출간 이력',
                to: '/publicationHistories',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '출간 결과 확인',
                to: '/publishingStatuses',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '나의 글 목록',
                to: '/manuscriptLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '글 상세 정보',
                to: '/manuscriptDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '출간 이력 목록',
                to: '/publicationHistoryLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '출간 이력 상세',
                to: '/publicationHistoryDetails',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '결제 및 구독 관리' }" />
        <VerticalNavLink
            :item="{
                title: '구독',
                to: '/subscriptions',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '결제',
                to: '/payments',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '구독 상세 정보',
                to: '/subscriptionDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '구독 목록',
                to: '/subscriptionLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '결제 내역 조회',
                to: '/paymentHistories',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '결제 상세 조회',
                to: '/paymentDetails',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'AI 출판' }" />
        <VerticalNavLink
            :item="{
                title: '출판 작업',
                to: '/publishingJobs',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '상품 정보',
                to: '/bookProducts',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '출간 처리 현황 목록',
                to: '/publishingJobStatusLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '출간 처리 상세 정보',
                to: '/publishingJobDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '전자책 상품 목록',
                to: '/bookProductLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '전자책 상품 상세',
                to: '/bookProductDetails',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '작가 관리' }" />
        <VerticalNavLink
            :item="{
                title: '작가',
                to: '/authors',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '작가 승인 처리',
                to: '/authorApprovals',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '작가 등록 상세 정보',
                to: '/authorRegistrationDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '작가 등록 신청 목록',
                to: '/authorRegistrationLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '작가 승인/거절 상세',
                to: '/authorApprovalDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '작가 승인/거절 내역 목록',
                to: '/authorApprovalLists',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '서적 관리' }" />
        <VerticalNavLink
            :item="{
                title: '서적',
                to: '/books',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '서적 신고',
                to: '/bookReports',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '서적 관리 상세',
                to: '/bookAdminDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '서적 관리 목록',
                to: '/bookAdminLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '서적 신고 상세',
                to: '/bookReportDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '서적 신고 목록',
                to: '/bookReportLists',
            }"
        />
    </ul>
</template>
