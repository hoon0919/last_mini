import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/subscribers',
      component: () => import('../components/ui/SubscriberGrid.vue'),
    },
    {
      path: '/pointTransactions',
      component: () => import('../components/ui/PointTransactionGrid.vue'),
    },
    {
      path: '/manuscripts',
      component: () => import('../components/ui/ManuscriptGrid.vue'),
    },
    {
      path: '/publicationHistories',
      component: () => import('../components/ui/PublicationHistoryGrid.vue'),
    },
    {
      path: '/subscriptions',
      component: () => import('../components/ui/SubscriptionGrid.vue'),
    },
    {
      path: '/payments',
      component: () => import('../components/ui/PaymentGrid.vue'),
    },
    {
      path: '/publishingJobs',
      component: () => import('../components/ui/PublishingJobGrid.vue'),
    },
    {
      path: '/bookProducts',
      component: () => import('../components/ui/BookProductGrid.vue'),
    },
    {
      path: '/authors',
      component: () => import('../components/ui/AuthorGrid.vue'),
    },
    {
      path: '/authorApprovals',
      component: () => import('../components/ui/AuthorApprovalGrid.vue'),
    },
    {
      path: '/books',
      component: () => import('../components/ui/BookGrid.vue'),
    },
    {
      path: '/bookReports',
      component: () => import('../components/ui/BookReportGrid.vue'),
    },
  ],
})

export default router;
