package com.example.articlereader.utility

import com.example.articlereader.modal.data.Article

object GetArticleList
{
    fun addArtcile():List<Article>
    {
        return  listOf(
            Article(title="https://review.firstround.com/draw-the-owl-and-other-company-values-you-didnt-know-you-should-have",
                status = "Unread", titleImageUrl ="https://assets.proof.pub/2056/firstround/PonLXGamRvepsD1UrlvR_FR_CEO15_0189.jpg"),
            Article(title="https://dunn.medium.com/make-a-big-deal-about-the-little-things-49044db95b3f",
                status = "Unread", titleImageUrl ="https://miro.medium.com/max/1400/1*StItySF9EEeRuYLLuhPOwA.png"),
            Article(title="https://build.affinity.co/learn-fast-and-read-things-why-and-how-we-started-a-technical-reading-group-56a61db515bd",
                status = "Unread", titleImageUrl ="https://miro.medium.com/max/1400/1*MGyu3fwG4VQLVp4w0OBTDA.jpeg"),
            Article(title="https://review.firstround.com/6-small-steps-for-handling-the-emotional-ups-and-downs-at-work",
                status = "Unread", titleImageUrl ="https://assets.proof.pub/2056/firstround/YKE4NN6GSdCrH2JvJ16d_GettyImages-135258374.jpg"),
            Article(title="https://dev.to/jlhcoder/dont-worry-about-failureembrace-it",
                status = "Unread", titleImageUrl ="https://res.cloudinary.com/practicaldev/image/fetch/s--SBksAfIF--/c_imagga_scale,f_auto,fl_progressive,h_100,q_auto,w_100/https://dev-to-uploads.s3.amazonaws.com/uploads/user/profile_image/654631/ecf6e602-04ee-45d4-a290-62df4a340b63.png"),
            Article(title="https://medium.com/servant-leadership/failure-as-a-service-937473b0c9b8",
                status = "Unread", titleImageUrl ="https://miro.medium.com/max/1400/1*knEW6Xun2oOS7YHQbTjm_Q.jpeg"),
            Article(title="http://blog.eladgil.com/2017/08/feelings-of-failure.html",
                status = "Unread", titleImageUrl ="https://miro.medium.com/max/1400/1*knEW6Xun2oOS7YHQbTjm_Q.jpeg"),
            Article(title="https://www.mindful.org/5-ways-build-resilience-every-day/",
                status = "Unread", titleImageUrl ="https://i0.wp.com/www.mindful.org/content/uploads/2016/08/alidina_resilience.jpg?w=740&ssl=1"),
            Article(title="https://medium.com/glitch/gratitude-as-a-company-value-4bc9c8f0a4fc",
                status = "Unread", titleImageUrl ="https://miro.medium.com/max/3000/1*quN5xHu4FrqzI6gppWuYEA.jpeg"),
            Article(title="https://corporate-rebels.com/iceberg-of-ignorance/",
                status = "Unread", titleImageUrl ="https://corporate-rebels.com/CDN/571-1140x0.jpg"),
            Article(title="https://www.strategy-business.com/blog/Put-an-End-to-Your-Feedback-Loop",
                status = "Unread", titleImageUrl ="https://www.strategy-business.com/media/image/39246762_456x264.jpg"),
            Article(title="https://sambleckley.com/writing/church-of-interruption.html",
                status = "Unread", titleImageUrl ="https://sambleckley.com/assets/images/interruption.png"),
            Article(title="https://medium.com/swlh/get-out-of-your-head-how-to-quiet-your-thoughts-1e239199dff9#---0-86%20%7C",
                status = "Unread", titleImageUrl ="https://miro.medium.com/max/700/1*4Mm2Vqe7hTZMNKRc6jaGZQ.jpeg"),
            Article(title="https://www.strategy-business.com/article/The-Problem-of-Virtuous-Leadership",
                status = "Unread", titleImageUrl ="https://assets.proof.pub/2056/firstround/OLMAkUk0RLWDMNcWyMvO_VNTR1822.jpg"),
            Article(title="https://review.firstround.com/how-this-head-of-engineering-boosted-transparency-at-instagram",
                status = "Unread", titleImageUrl ="https://assets.proof.pub/2056/firstround/OLMAkUk0RLWDMNcWyMvO_VNTR1822.jpg"),
            Article(title="https://inteamwetrust.com/2016/06/22/trust-toolbox-for-virtual-teams-module-1/",
                status = "Unread", titleImageUrl ="https://inteamwetrust.files.wordpress.com/2016/06/d0b1d0b5d0b7-d0b7d0b0d0b3d0bed0bbd0bed0b2d0bad0b0-e1569397969805.png"),
            Article(title="https://www.mindtools.com/pages/article/building-trust-team.htm",
                status = "Unread", titleImageUrl ="https://www.mindtools.com/media/Resized-Images/Articles/Team_Management/24_IS_22354906_BorisJovanovic19_2x1.jpg"),
            Article(title="https://agilecoach.typepad.com/agile-coaching/2010/08/building-trust.html",
                status = "Unread", titleImageUrl ="https://miro.medium.com/max/2000/0*azywUzeP9TzGhfvB"),
            Article(title="https://dvirsegal.medium.com/building-trust-through-effective-communication-c00bf9b65c78",
                status = "Unread", titleImageUrl ="https://miro.medium.com/max/2000/0*azywUzeP9TzGhfvB"),
            Article(title="https://knowyourteam.com/blog/2019/02/01/the-bottom-line-benefits-of-building-trust-in-the-workplace/",
                status = "Unread", titleImageUrl ="https://knowyourteam.com/blog/wp-content/uploads/2019/02/Untitled_Artwork-1024x551.jpg"),
            Article(title="https://opensource.com/open-organization/16/10/building-organizational-trust",
                status = "Unread", titleImageUrl ="https://opensource.com/sites/default/files/styles/image-full-size/public/lead-images/BIZ_HighTrust_1110_A.png?itok=EF5Tmcdk"),
            Article(title="https://review.firstround.com/humans-hate-being-spun-how-to-practice-radical-honesty-from-the-woman-who-defined-netflixs-culture",
                status = "Unread", titleImageUrl ="https://assets.proof.pub/2056/firstround/1x0s4s13SB2OUNsHwBbe_maxresdefault.jpg"),
            Article(title="https://hbr.org/2017/01/the-neuroscience-of-trust",
                status = "Unread", titleImageUrl ="https://assets.proof.pub/2056/firstround/NaY26azBTCyxurgtbXWu_TrustonTeams.jpg"),
            Article(title="https://review.firstround.com/our-6-must-reads-for-creating-and-accelerating-trust-on-teams",
                status = "Unread", titleImageUrl ="https://assets.proof.pub/2056/firstround/NaY26azBTCyxurgtbXWu_TrustonTeams.jpg"),
            Article(title="https://inteamwetrust.com/2020/03/24/team-trust-canvas-session-online/",
                status = "Unread", titleImageUrl ="https://inteamwetrust.files.wordpress.com/2020/03/5306bd1b-9733-4456-a8c9-3a46994df2b0.png?w=720&h=523"),
            Article(title="https://knowyourteam.com/blog/2019/02/12/the-3-most-effective-ways-to-build-trust-as-a-leader/",
                status = "Unread", titleImageUrl ="https://knowyourteam.com/blog/wp-content/uploads/2019/02/building_blocks-1024x564.jpg"),
            Article(title="https://inteamwetrust.com/team-trust-toolbox/trust-anti-pattern-cards/",
                status = "Unread", titleImageUrl ="https://inteamwetrust.files.wordpress.com/2019/09/img_5305-e1568640557156.jpg?w=720&h=540"),
            Article(title="https://medium.com/@orenellenbogen/who-should-own-your-engineering-team-s-skill-debt-3c3f07bbefe9",
                status = "Unread", titleImageUrl ="https://miro.medium.com/max/1400/1*9MIXeNmTsxYU5JTEmjEFPw.jpeg"),
        )

    }
}