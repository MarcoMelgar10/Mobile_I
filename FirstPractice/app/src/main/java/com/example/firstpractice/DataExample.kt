package com.example.firstpractice

object DataExample {


    private var users = listOf(
        User(
            id = "1",
            username = "St Bernarnd",
            post = UsersPost(1).get(0),
            mail = "stbernard@gmail.com",
            perfilPicture = "https://i.pinimg.com/564x/b6/0f/6c/b60f6c4fa85efb0207a6522ac1e28969.jpg"
        ),
        User(
            id = "2",
            username = "German Sheperd",
            post = UsersPost(2).get(0),
            mail = "germanshepherd@gmail.com",
            perfilPicture = "https://cdn.shopify.com/s/files/1/0894/7020/articles/german-shepherd-breed-profile-382556.jpg?v=1627490239"
        ),
        User(
            id = "3",
            username = "Golden Retriever",
            post = UsersPost(3).get(0),
            mail = "goldenretriever@gmail.com",
            perfilPicture = "https://www.dogsforgood.org/wp-content/uploads/2019/06/Georgie-web.jpg"
        ),
        User(
            id = "4",
            username = "Husky",
            post = UsersPost(4).get(0),
            mail = "husky@gmail.com",
            perfilPicture = "https://cdn.britannica.com/84/232784-050-1769B477/Siberian-Husky-dog.jpg"
        ),
        User(
            id = "5",
            username = "Labrador",
            post = UsersPost(5).get(0),
            mail = "labrador@gmail.com",
            perfilPicture = "https://animalcarecentersmyrna.com/wp-content/uploads/2022/02/labradorretriever2.jpeg"
        ),
        User(
            id = "6",
            username = "Bulldog",
            post = UsersPost(6).get(0),
            mail = "bulldog@gmail.com",
            perfilPicture = "https://d128mjo55rz53e.cloudfront.net/media/images/blog-breed-bulldog_pvbswXQ.width-550.format-webp.webp"
        ),
        User(
            id = "7",
            username = "Poodle",
            post = UsersPost(7).get(0),
            mail = "poodle@gmail.com",
            perfilPicture = "https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2023/09/06151834/Poodle-standing-in-the-garden.jpg"
        ),
        User(
            id = "8",
            username = "Chihuahua",
            post = UsersPost(8).get(0),
            mail = "chihuahua@gmail.com",
            perfilPicture = "https://www.vidavetcare.com/wp-content/uploads/sites/234/2022/04/chihuahua-dog-breed-info.jpeg"
        ),
        User(
            id = "9",
            username = "Dachshund",
            post = UsersPost(9).get(0),
            mail = "dachshund@gmail.com",
            perfilPicture = "https://consumer-cms.petfinder.com/sites/default/files/images/content/Dachshund%204.jpg"
        ),
        User(
            id = "10",
            username = "Yorkshire",
            post = UsersPost(10).get(0),
            mail = "yorkshire@gmail.com",
            perfilPicture = "https://cdn.britannica.com/48/233848-050-C8254DF7/Yorkshire-Terrier-dog.jpg"
        ),
        User(
            id = "11",
            username = "Shih Tzu",
            post = UsersPost(11).get(0),
            mail = "shihtzu@gmail.com",
            perfilPicture = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4D-kGXn9ZO_Te1Omd3Zbi73thDl1z4r4SUQ&s"
        ),
        User(
            id = "12",
            username = "Pug",
            post = UsersPost(12).get(0),
            mail = "pug@gmail.com",
            perfilPicture = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRW_K0rtKPOwZgTNq8sZhR_7reYwX7DntM5Sw&s"
        ),
        User(
            id = "13",
            username = "Border Collie",
            post = UsersPost(13).get(0),
            mail = "bordercollie@gmail.com",
            perfilPicture = "https://pawsclawstails.com.au/wp-content/uploads/2024/02/Introduction-to-Border-Collies.png"
        ),
        User(
            id = "14",
            username = "Rottweiler",
            post = UsersPost(14).get(0),
            mail = "rottweiler@gmail.com",
            perfilPicture = "https://cdn.britannica.com/69/234469-050-B883797B/Rottweiler-dog.jpg"
        ),
        User(
            id = "15",
            username = "Boxer",
            post = UsersPost(15).get(0),
            mail = "boxer@gmail.com",
            perfilPicture = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWAx7AUQe0eWddfa3Mp_CCgzmGHUK6Ja6QoA&s"
        ),
    )


    fun UsersPost(userId: Int): List<Post> {
        val images = UserPhotos(userId)
        return when (userId) {
            1 -> listOf(
                Post(
                    id = "1",
                    status = false,
                    likes = 9,
                    images = images,
                    usersLiked = mutableListOf("10", "2", "3", "4", "5", "6", "7", "8", "9")
                ),
                Post(
                    id = "2",
                    status = true,
                    likes = 6,
                    images = images,
                    usersLiked = mutableListOf("10", "2", "3", "7", "12", "14")
                )
            )

            2 -> listOf(
                Post(
                    id = "1",
                    status = true,
                    likes = 12,
                    images = images,
                    usersLiked = mutableListOf("12", "14","3","4","6", "7", "8", "9", "10", "11", "13", "15")
                )
            )

            3 -> listOf(
                Post(
                    id = "1",
                    status = false,
                    likes = 9,
                    images = images,
                    usersLiked = mutableListOf("2", "3", "4", "5", "6", "7", "8", "9", "14")
                ),
                Post(
                    id = "2",
                    status = true,
                    likes = 3,
                    images = images,
                    usersLiked = mutableListOf("12", "3")
                )
            )

            4 -> listOf(
                Post(
                    id = "1",
                    status = true,
                    likes = 1,
                    images = images,
                    usersLiked = mutableListOf("9")
                ),
                Post(
                    id = "2",
                    status = true,
                    likes = 2,
                    images = images,
                    usersLiked = mutableListOf( "2", "3")
                )
            )

            5 -> listOf(
                Post(
                    id = "1",
                    status = true,
                    likes = 9,
                    images = images,
                    usersLiked = mutableListOf("10", "2", "3", "4", "14", "6", "7", "8", "9")
                ),
                Post(
                    id = "2",
                    status = true,
                    likes = 2,
                    images = images,
                    usersLiked = mutableListOf( "2", "3")
                )
            )

            6 -> listOf(
                Post(
                    id = "1",
                    status = true,
                    likes = 2,
                    images = images,
                    usersLiked = mutableListOf("8", "9")
                ),
                Post(
                    id = "2",
                    status = true,
                    likes = 2,
                    images = images,
                    usersLiked = mutableListOf( "2", "3")
                )
            )

            7 -> listOf(
                Post(
                    id = "1",
                    status = false,
                    likes = 9,
                    images = images,
                    usersLiked = mutableListOf("11", "2", "3", "4", "5", "6", "10", "8", "9")
                ),
                Post(
                    id = "2",
                    status = true,
                    likes = 5,
                    images = images,
                    usersLiked = mutableListOf("5", "2", "3", "13", "4")
                )
            )

            8 -> listOf(
                Post(
                    id = "1",
                    status = false,
                    likes = 2,
                    images = images,
                    usersLiked = mutableListOf("3", "9")
                ),
                Post(
                    id = "2",
                    status = true,
                    likes = 5,
                    images = images,
                    usersLiked = mutableListOf( "2", "3", "4", "5", "6")
                )
            )

            9 -> listOf(
                Post(
                    id = "1",
                    status = false,
                    likes = 9,
                    images = images,
                    usersLiked = mutableListOf("2", "3", "4", "5", "6", "7", "8", "10", "14")
                ),
                Post(
                    id = "2",
                    status = true,
                    likes = 5,
                    images = images,
                    usersLiked = mutableListOf("2", "3", "10", "11", "3")
                )
            )

            10 -> listOf(
                Post(
                    id = "1",
                    status = false,
                    likes = 1,
                    images = images,
                    usersLiked = mutableListOf("9")
                ),
                Post(
                    id = "2",
                    status = true,
                    likes = 5,
                    images = images,
                    usersLiked = mutableListOf( "2","4", "7", "8", "9")
                )
            )

            11 -> listOf(
                Post(
                    id = "1",
                    status = false,
                    likes = 9,
                    images = images,
                    usersLiked = mutableListOf("2", "3", "4", "5", "6", "7", "8", "10", "12")
                ),
                Post(
                    id = "2",
                    status = true,
                    likes = 1,
                    images = images,
                    usersLiked = mutableListOf("2",)
                )
            )

            12 -> listOf(
                Post(
                    id = "1",
                    status = false,
                    likes = 1,
                    images = images,
                    usersLiked = mutableListOf("9")
                ),
                Post(
                    id = "2",
                    status = true,
                    likes = 8,
                    images = images,
                    usersLiked = mutableListOf("1", "2", "3", "4", "10", "11", "12", "14")
                )
            )

            13 -> listOf(
                Post(
                    id = "1",
                    status = false,
                    likes = 9,
                    images = images,
                    usersLiked = mutableListOf("1", "2", "3", "4", "5", "7", "8", "9", "10")
                ),
                Post(
                    id = "2",
                    status = true,
                    likes = 3,
                    images = images,
                    usersLiked = mutableListOf("1", "2", "3")
                )
            )

            14 -> listOf(
                Post(
                    id = "1",
                    status = false,
                    likes = 10,
                    images = images,
                    usersLiked = mutableListOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
                ),
                Post(
                    id = "2",
                    status = true,
                    likes = 1,
                    images = images,
                    usersLiked = mutableListOf("1")
                )
            )

            15 -> listOf(
                Post(
                    id = "1",
                    status = false,
                    likes = 9,
                    images = images,
                    usersLiked = mutableListOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
                ),
                Post(
                    id = "2",
                    status = true,
                    likes = 5,
                    images = images,
                    usersLiked = mutableListOf("1", "2", "3", "4", "5")
                ),
                Post(
                    id = "3",
                    status = true,
                    likes = 6,
                    images = images,
                    usersLiked = mutableListOf("1", "2", "3", "4", "5", "6")
                )
            )

            else -> emptyList()
        }
    }


    fun UserPhotos(userId: Int): List<String> {
        return when (userId) {
            1 -> listOf(
                "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQovvuAwnoshI1ZsCFkLercUd9bYuiOWxEkq-97chMU3jyhH1CdcRefePMtYTt2ItqKs-wF9MDVb2_WSaeOyoMAB4TUvWRTlNugmVOMqQ8ckA",
                "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSMJOzKN6rs8xuT1I-XDrXY42sIDI6Qpwh8IHKS1U9D5K6KPJfmpHZTxCIrBPrwCMp7HjFoq0q1LYrA0cFdvJQTo8euOTaCj7x2JHTpgVaS9A",
                "https://www.dogster.com/wp-content/uploads/2024/03/Happy-saint-bernard-dog-playing-outdoors-in-autumn_Rita_Kochmarjova_Shutterstock.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQiJvN7nP2lBua5dxSqIH9gbhbn_x9knHd02-P_WDKWXbMxqey2nl_mtuRKrAuJC9kES88&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTNWs9iPBjHqOkHQOCSYmtJM1rHGK8Bn6QZzKqLSko-rLTCIykFYLxeAi97DcAoCrItYlY&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6mxKWKcCI-Wl9gkSU4-qUxrN_wODOedvmAzNEd2zIIicEtrY6WsK_PTzxdQBPWW6UtJg&usqp=CAU",
                "https://media.istockphoto.com/id/512890747/photo/saint-bernard-sitting.jpg?s=612x612&w=0&k=20&c=UhlbjYoxtHrOQkLFa0p-1QAISjDnvV67NQ6C8Fmz5lc=",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBBcfHMa4hrW_MGANamKBq-rPu23kf2hyVWg&s",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT0VnnqklWmaEC4aGsr8L9BCDV90YpByo2Iv_X799eGJhveUzSHRm_DZthi_pjC2fk7z5c&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4u4Ve7dJDA8NMoyv_-YbfuhSauznB8jVUfV851BOBm0rKfRv16xpNxfVonKuziP8wx9o&usqp=CAU"

            )

            2 -> listOf(
//                "http://t3.gstatic.com/images?q=tbn:ANd9GcSVnmd1j1g663aj3oevYTEjNw-3BRi6mngABdSgX3LS-ZZY2D8mVwhzZM0MJm0EUitZKUEMbdTS",
//                "http://t2.gstatic.com/images?q=tbn:ANd9GcQArLeqSnDhIycLeEKMM4Vnj-FWz4xtV7vHLLVtvmAb-KfBN40IZ22FDPJ1OrbscR16qiZIXdC-",
//                "http://t3.gstatic.com/images?q=tbn:ANd9GcQF4awCzNuXZiZ6ezZNwDFz6w3UyMUS7r_coAnLWwO1IZeEJ_FGynUv4ayyK2xl-uqwULq7O575",
//                "http://t3.gstatic.com/images?q=tbn:ANd9GcQF4awCzNuXZiZ6ezZNwDFz6w3UyMUS7r_coAnLWwO1IZeEJ_FGynUv4ayyK2xl-uqwULq7O575",
//                "http://t0.gstatic.com/images?q=tbn:ANd9GcQ5s4228YV8nj0Bagaow8rqmP0nCChAwRK3ydmAJLBA4AWQ1ZFF-xC8njhEFF2y5gBSNLy2iDvk",
//                "http://t1.gstatic.com/images?q=tbn:ANd9GcRERbigTf7GijVxtu0wupY-z3CRZ9eSqSNlfCYfQ4lTDpoFj25WDkotWtgYVF-2xeRX4nOAl34C",
//                "https://cdn.mos.cms.futurecdn.net/Tdom4TwTjsVFLhXrNqnZHS.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR6vK9XGVpsZJyLqihEWrl8FZlRTEIvPpn90KC5OnJRh2qiNiEzy0JBlls0ZV3_rkQOmdo&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUX7ovrobGxLm3yUtEjhRYW1sUgB63ZeCofv34gaphCYkF8B7JuBm7p59lhdiG5dRDDQY&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTodUyO_tHrcDD82Uvi1ljSPu0QnVr7bdnq2w8M2ZaQlXEp9RmDPIC4pvtkRqANJa-3gdw&usqp=CAU"


            )

            3 -> listOf(
                "https://images.theconversation.com/files/625049/original/file-20241010-15-95v3ha.jpg?ixlib=rb-4.1.0&rect=12%2C96%2C2671%2C1335&q=45&auto=format&w=1356&h=668&fit=crop",
                "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQ8PwlYqDGozO1pGQfRbVXN0O5N036AFzK8CtVJ1mya3u6xj_9ChpHQBsSWA6hboAyIssBaROErkwuv7E25GIRY2V6a--8sD-0CcO_LBoF-",
                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQWpCUZOniC3mEyHAu8Us4_RpzPXWsTAIvCVZucRs_mSiTULjEztbi7G7n8v4GaWW3qNwcAYUTbGxjBoxvLNJb996aqzK1KaR5sxt7hy5Hf",
                "https://www.carecredit.com/sites/cc/image/article_golden_retriever.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrF1JfLByyUag-ISYsRO1SYJSdQMXAi9pxHEpfhxH08bRb0EyVmjnEO9YVG0nO0Dnut4A&usqp=CAU",
                "https://vetericyn.com/Vetericyn/wp-content/uploads/2022/08/golden-retriver-ft-1.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrF1JfLByyUag-ISYsRO1SYJSdQMXAi9pxHEpfhxH08bRb0EyVmjnEO9YVG0nO0Dnut4A&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3jJ3W7BwNcJUYDKPiGZLjLSpK3xiU-PcMrw&s",
                "https://naturalinstinct.com/cdn/shop/articles/Golden_Retriever_Dog_Find_A_Breeder.jpg?v=1740586047&width=1500"
            )

            4 -> listOf(
//                "http://t0.gstatic.com/images?q=tbn:ANd9GcQ8b_XxjNTar7EtqHZNs71V6RIGDW0FtIw1Qco-ZP4CQSWeZ86PUm80InX9ZhiaMNrwGaBNLwt2",
//                "http://t0.gstatic.com/images?q=tbn:ANd9GcQ_jt9DLmHVkKfcRX4kBFJJkYXXPRZu-Fky5eW_blm73usl0ykiqF99-qNxHj2EzXwE3YDJEF5K",
//                "http://t0.gstatic.com/images?q=tbn:ANd9GcSws0YOPg65mDrk9eTHnRJ1gaWFw-0lDJn213ZrHQXGmyLiyTqU3w3Z9jyu4zoWTNvMD1WUh_hC",
//                "http://t2.gstatic.com/images?q=tbn:ANd9GcQTHqIz3WpAL1_cHYv-_1ge2cxYdKjcoLqakSsboGqhQa3yvYttDY13JLt4IyLzqi_dyHq0df-m",
//                "http://t2.gstatic.com/images?q=tbn:ANd9GcR_VDxYtB1KTPiEZuIOfNfbSXlL9s_rzmMm9dioGXLxW7xwAtBMNZYPp9Z86fEjk3LNj41gWI-g",
                "https://waggys.pet/cdn/shop/articles/Waggys_Blog_16_Tipos_Husky_1920x.png?v=1683087710",
                "https://cdn.mos.cms.futurecdn.net/3RNRsqYLopjbypxutWyEWb-1200-80.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQ6nKC1fKlqXIGs79cABGAhb-bnLzVm3HGLpAkkqHMZOx6mdc8vRc-AIpS0biND9W9tac&usqp=CAU",
                "https://www.zooplus.co.uk/magazine/wp-content/uploads/2024/07/Siberian-Husky.webp",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2-549h4hg3aexqCBI0q7q5Lu4e0zZO6GVtIgMt6S-djbTFH2N2glqvmokzMNSbJZS_Ws&usqp=CAU"
            )

            5 -> listOf(
                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQRiGd8gcuJwerFL5JDq3W0fodwnPaM1afqqQrLt9Vl28ECMT0QTVAQDqBmjvotr092nHCY1vuUa2I7PYb1ezbdAqPBwKm4mhKVRvUDwgO8",
                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTZReSIx7JlR0Jm_SX0xZxsxfln7xr8V6r3CVe0KBIv_66Oc7NXjpJ2noYJFh0oed5h_kP0yOc3Axrj_1lL4awkxNoCNwQdGj0o4lCuj952bg",
                "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSL8Jm_Kxs1NCM47KA7whdwJJPMgmO_xJ6MMi4U_TlzVVsLlQNLHP65cmYFcfaNhcwoTia6ht50CfAP9cAwl3hiMWcPmLPDGlg4nrCeYBFN",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZYlLd1rLRGtRwsTJCnWJHINh08WNG0qPFBkTCxt8nVliePSWeEcVNS_-5Oy2bQNRxaAA&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRceUGVPQ-Zan9aLCMUJZEuHb6-V4TE9C-3gLOIqZ5qhZH7sbqvO46sdlwHkybVec6jG98&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSaPfycR3R4xFWxrxUvAPJnvF7t8WMlIJLe1DGh4KGL826HA4wj0r0f1sN8NdALMiSeuY&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqeEDFUMZmI8WAs5FnLYnXlQG4rOvg0Cy2OpXBpfyYRP2YGs8LqFbn9ERvSS5kc6FA3eQ&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbfMsJqDVSInFhK1MY1oeCa1bDUqqtzoeDetGDKyqnh7E7nyBkRH5BN9K_5QeKivyYvAs&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbfMsJqDVSInFhK1MY1oeCa1bDUqqtzoeDetGDKyqnh7E7nyBkRH5BN9K_5QeKivyYvAs&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_Butz__lrVW_eoyd8RV2d6cNd4hyVLyQLmv31CrWeP1d3FwL1h8j3B5VgcrlEDyTCNZo&usqp=CAU"
            )

            6 -> listOf(
                "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQU1ygWpiAijlc4OrxOKMVKClrMj50bRy2UFt2CunoefnwCOh-UgwiHc_J_By8Ebr6etN_XRJKC1ykS77hxNcPDYDi2NJ3leC7nbPd_HWsZ",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnLQBk8yPMHfBWlLXqs4Qc6fC43Ci5REbyaLO8XRc_1GG89ruRhS4atUk6E1hglbEW7DHfmbClcNq7z-10xr4Oj2wRYlChi-wkpH9Bvqz0sQ",
                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcS6y2PyOdtzJMmU7J1bzdaes1_YN4lkEGA8Mn7LeqjuOiHexL-xxkTbSCEr4WTohSjBDPzWsTNZoDnB5spSxNgwZ0x3qEmRNFXlpSg0_j_atA",
                "https://image.petmd.com/files/inline-images/english-bulldog-5.jpg?VersionId=1KyTFgo4HZwpAcjf.WZ8mM_2yt6f9Zc3",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgfNpYLXFUm86f5uqNaxS0_qcvrkifjp_79QJ23fyLpJzmszOJue_DdEQPk5reJYILWag&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQs7Hs-AFvXkbUj3vaQEGkLYEY8M3kwZ5EP7Stz53F5No3qybV889p28XZPbwjMrvfUBcg&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSzakVYs0kn4GMWciSyoK9IwhUSgOjOrXEFh00ehXQA37X3bOrCi9rmUDrVGnxhpbCUFe8&usqp=CAU",
                "https://spotpet.com/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fm5ehn3s5t7ec%2F3LlwQXcjlcCtNFqg7rswmx%2F0f268311a5bf518cc72fa1b5a3f957b1%2FBulldog_Price.jpeg&w=3840&q=75",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRrWzgJwCgg4_HZFVlGnkWBxHjRBygUQ8XUZjAxLon_oaC7Str-37ePVyCWU1uiNGZUxAU&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFaBV48VZ9K7ff6Qx648joOu4CXSkM2u5Fuzhbxu8T_-K8LvRQi-K72vdhaui4xAql2DQ&usqp=CAU"
            )

            7 -> listOf(
                //"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ2xb585nZpaMM-IDq3ERKW6pbteX-d9u5Muw&s",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ2xb585nZpaMM-IDq3ERKW6pbteX-d9u5Muw&s",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVN9snvWoeEYM5_1qhHpIca3H-Um85U6miYPCHiay4APjFNY5jUmJo-5LDMREgv6Uwfoo&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_G5mkzS42BkYOR-Z-dMexuwVU8dGtmNliB8p-v2qCmslwLAgEgfaFousKCM5kAuKqgMg&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfGL1gIJa6yT_GQL-VFL2rrxkqwC6O7ip48P-MNUz4i8OGEdMCHkndI1jfqW8oETNk12k&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvK2FoasM3JChsyfU03EZqeX2A3u0gHnEWJGzquMh3H2hM-aZWPQNLdYe9VoVHEFk32sc&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQuvpF39uAMYG5bWxeV6Ah1p6uFfxoLHPdn6w7jt5UU_uF7Nh-ljBpRtQXEXVYUV3-niAM&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQK8rVBeWA3wUOJwGshda3kKiu_3FL2YEPS5DYP1lt9FJ6R5Vv-L5_wvSi2Jf9n2GISjeA&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkj1h1B1YglSeP2y6f-sh8O3SFnxfFQD95s80Sl89Kc-Zd43msGqwyqvLEUfWFrZH-gQk&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLhrbxxP25PbBukG1zFhNzLq54CMA6AC0oA7axs5WqME3_JJaiB0fxbm3TkUfMcX_E7wc&usqp=CAU"
            )

            8 -> listOf(
                "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSPkfWUz6GNsRSM8RwkuG5wwCtG-QxtjI5viBWOUT3LRg3W_7kungovLwzyE0d_6aljoUHn2612XMWir1E2WoUZZhpKFHVyJplzE-nlBNAD",
                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcS3YU2fEOkl_EFmL85AHQbZWp2o8P1da0IcMXjx8chWhML1OFgEfP-E7oQ4TYk00-UxQMWiHmg6w5tU8dHaAE4J711_YG9knohc68T8t9pwOg",
                "https://www.purina.es/sites/default/files/2021-02/BREED%20Hero_0034_chihuahua_smooth.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQBN61b0rGuGF5SCl_i0JIWBCR4ue8Cxrsf1Edp62lnEv-2uYU0gW9lao0cuawRqxfiVpw&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxSdrhXgr3nyBArDi3CHC7dY7T9thFbBI2DiQ_6GDH3I6Wx4b27JXjALOE1HuGKrHvBmY&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTuuHNcuJQZchS_ViBXTtUVBdmoT3WhamfDjZ5TpZD8kgnBByRIJLJXndiV-oo-sv-DTks&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHX2i8bapHBgSVjYpqAxyvXELldVz3lui_asOg9N1KGTHS3u6OnXxmYbUlMZ998nPcolU&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtoEhhm-HFFBRSis5kToQr8V00lXj8apTqau1hmwt6ofy_mDIU4DsLdTEvtnJa4pPuDbo&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRp_XQmVA2uKe4JilkdYtd2tXEx96rh_81Hqg&s",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTI1WWLWIoRfPtztwbeG4C3GPc4X1-v7JYihQO2EBbeCo6xhnDt1oWm6gQbEo2cRkQbiYk&usqp=CAU"
            )

            9 -> listOf(
                "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcS3_2Of0puTbUVX30npIyvmNmI9puFapAkWHUOEjAIGYJPb3RGZxFPKGBMCeIkVGFwsnGSm9dJ_5R4sa4oJqc1Ig_gC3bOhyjStXsYI_FBM",
                "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQJVhksZsnzKxhILPJF5Q-IvlA4K2MIHg185OGfCI15Era2k13d5xDMwCWT2AeoMYWGgezUfCfp5-Vtzkp7akzywK7skSfBLt_pvy43HcKtDg",
                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTqlwYXQMoxDflP_iF0AKfa9WqVpVvsqmaTp_QWogUHDuIj-SDUZg_Csspuakibl98AnO4yPWYzcMO1ibBmiMBSkdRXL60oAcP0lKe66KoO",
                "https://www.simpsonspremium.com/cdn/shop/articles/dachshund_800x.jpg?v=1636106720",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRwnVpiHRplcH_vF0Vx7qUvroXyXVIMU8RRnP992ZE3p75zYwZpP3SveJqtB5p8RV5QblI&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTB1F27r60SGpjnvS3QUQRbNSXIGrWTwIX7TpY8NcZJVsH_1YCe1C_hjd4xNHGMY0T7VBE&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTInKbge4LivXVyWtt_kMSYLGWoPdcN9jaupmnr_VAKgIqJxEqMADyHPYsDYNoLm0evzJU&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBJLXsBHsj3KffunWIWmuRrwrrMKOvaCJ6nEazuCWMlkftfnTObt7GmFmX8a-YN2Jjt_w&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCWrU7Pddp16KIlVDb_ZLIbCEsMYgTi4_kvvfAplMwOBZx4peIg7do-frb-SwzRcOKmEA&usqp=CAU"

            )

            10 -> listOf(
                "https://www.zooplus.co.uk/magazine/wp-content/uploads/2020/11/yorkshire-terrier-im-grass-768x567.webp",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4cvGphBM4gZ80hIZ2GMQQoRtKe9qYzICwhvv2jBtvMCrZzX3v6jQp9nxpjPn-PAz3iEw&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfkiWkaPsKuDBXoyfshlCxecpzvv76A3NZJ1Q5cxTQ_fzkpH2VYev0d6tAATsr-tUIfpk&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR9aSusJBc6wwSwu0vp_s9NK3QzMTc7tInIMD0-9A6q_wupUKKoR8TrHAZXmEQ3kSC185M&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSh8cIKIOm6e74Sqkb4TcKfB_tWGbJy8F66g_AxFw1GYd75I0Od8U4kaOYAVhTLXmcRX1U&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEn7jW4ZTZ_ObB7pmEUXeW1l4jU2z8Nxe-GZEC5Au7FDrq85gr5-vcPG8eQPkk1nOzM2M&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwAJal0HapBNoVDoeCCELKKZePB12sxw-13auLsDo-Cz8Tk3ZHnonHnIhLCxM8fndK-k4&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQ0nVZwN0_dSmN2VUsvA4IQr0Rq4WuMr8UpI6rKu8GHToJMv1MeO3je0zfFKBEJ2jSk_I&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTOU1iGTTqRtugvNMujr2V8gLnCoVE0FapN92f2LUBnY4kSJPGfe6tOMplQJ4NwP285xX4&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJKFTQBVGoaa84Aci3tT4mKXMjtnupYIzIumDcF3n2OvboSd4z_CFPwjzxjy4WI50h3uU&usqp=CAU"
            )

            11 -> listOf(
                "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSI3OMVnUOLyWlhZ0x81oPjZik7EMZkx84cP2I5xz9YEqXyKt64M-fwGkL07_ONLHuKm05zWWQGS1K4_JGRyHYuG-fL0twsjzf2YKmk24jy",
                "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTAnPqFRvsf7uos2Y07sk055UDQ6_WQOyrX7l3QKE_GKamvh7IeiQWSe4L3unXKqzdiBvlUsT35Ye5z7NWglrNwAT8C4pseIO6TLNkgstJWcA",
                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRAUy6m--f-l_rtO-GmpOtG3zNH2gOGp4S_YeJrpNKVwEUFXVXkZdnpAPlIf_qbHgUZ_t5DnoFJ7zcjp4h2QeDj7svCFcau7Yxtt4zTKBNM",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7fxqN3fPU7l2nDeMoKWbHA5ULxCNJYIdV4mrgV45UUG6XfyFYuj3wV8g0vvpWeXs8djw&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRS2wP354fFvhs3ggOl0yPkl0MMOnWiMqkTvuebV164MRwuQIuFYayRLeii6lWq7cW2-U4&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0IR5BPq7yRtzM2EbxMfV87Ozo-b4c20uga0UNmfJNO89hzeHaRDWUE6vywBVApcugsR4&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbvxlmdnacHQMBSz0wgRdVyEn_QMkU3e37bgH6jWPO3VXTA7dR9UAnGZv-JS3cbY3qJ7o&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQyjMTAk4gImnYwFRHfSYkDT3WogIk-44cEpRIneGtuXAfKcpSLYrGVY2FbsQo3DQliYCw&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTBxPrSaZ1-AOoBZxEhWX7I7DT2eHid03TEmpETrCM7oGmn_y4edpY59bg5pparRKJRGs&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQq0KNf1AGx4vxeHXqzqKsxB-Rx3UB_KGeclLISqH44Ly8uoFFq4NKGhh1TN0D0W8rHu8&usqp=CAU"
            )

            12 -> listOf(
                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQPbz6NUgW6R0WRK25gHuXpfEpPymgGtaHlnWW5NtgCsNMxNBpyJiQedCPGzktV6SpYXux_1NeWa1aYSc4ygXIg4lidx7FjsgMTGhEZ2gg9",
                "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSueuCeH5NLOySKH1ONwQ0pEThmjGHXr17C54sRDzromZ88IbAhJq-IFKAPCqhmiKOEtPScl5Eofq_EPSJY9erI27JKvg-bWSZZOGPGbZOn",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1y--njKlR0b4IYf8pxN92d9EPb04sIWg4fp4Sdt0pIdYQVtU1OzzmW8CmHBrsyDc0Xp5Pn9hm9V0psTkReShzbXVRkWZbhtBOY1vV5e3JEw",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQUnAAHReG00AvIeBYuzg6_NNU9qPMTC-hCrCWoEPRUXff_ezmRlZLRl0y173d702QPdWw&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSa7MBE8Yoxhp6Ov5Hv6TjAoFj4tbbPdNUeVIVoUGEjBwu2KpP285JKmJaCZ38W9pciWr0&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSO631K60V3AKbjmxqj21l5QgZzfbv8_dMjNxkoUxuTSPZn_M9gYc4G3GeL6lvdnmGXrs&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLISFT3e9Z8Olj8qeu5zfgpYoTrE9RHqt3VXmA5GnrWAkcvXQsJrMLnAeu5W-weNIow1Y&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYlzYu5ZqQ2jZ1fVXkJf-qKfFxIYaGUc2J3iDYrcKt1PLvuzdGPYRqE-avvAm89piHKgM&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZJ6xmdifhxUYg70Lq4_B6zhFnKpxvp8zlZQuYdMgDwzSwPrbNDUbtbdYjMa_5pRg8sAw&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShtlQdyAChFxC6syk5E7TxdjBXPw79x06acrS6GzhvyUnClgTNB-hgyetdzvXa24pfj4Q&usqp=CAU"
            )

            13 -> listOf(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWjHyXoOXJnXoCY1Hxn5c0sAV7zXXDT9SbcfZ1yyWiOA08AgBcuYHesuBlHmYFHBV4Pt0KliF4Poa1-Q1BEaRriiRZNAf3BlLxaIcU0fkwxQ",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpK3xbxULpRvSyCLqCCgYgDu2m8vRIRvU2vjMRdOyXytQKr4egCd2Gp6CWAMBn-niJyPOVdC_21oxSCinbJupdbxk4V-REVJk3OiJ8mrz3",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWTKRaF7UnutKS0qgXcJfudsd8rsFmhHvblri9ASjJ4C7ZaHkyGKi3TZFYdOFkqtQNkKI&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTH8xUU2COymnOzk6QJT6mRD0nTMWkYT30Es8Epc5qkhtG9W9kN6LavZk1Mj0Ws7qYILBY&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGqmGIHaEM2_4pA59fTMAGezN-JN3PpJaMIbbPp3gg6TGrXApHaplXvtbxCuocASFBpFg&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSv4QG5FDAyJHAknuqowQ-f_-KG_BUkE5T3o0rOz3u1d1ALiP8MGtPB6X7aKftG_7hhqpQ&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZOfKP8astlLx51TaCVUsU8seVe7mdGM3STvAW1P5lb1xjtBVXtWUfjhFRC0aUhXIo_M0&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLqxetSeNZR3fKXfqQDAKUZ87QptYhuQ6tIjv7amPF7bc7-y8ccUqcYk-ot1E4EjeSLrU&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCoSq1Q-z5GVGOH4x9jq6f-TSmzVN08cBh2e_c4lLoxPolIiqW6mm1jHQAyF51pyvnkac&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTKnHCr3CffmjJxXBiDnXcPhSdhEljkNnB9tw&s"

            )

            14 -> listOf(
                "https://cdn.britannica.com/69/234469-050-B883797B/Rottweiler-dog.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtzxp88ItLDdW96mGOIgynkmc-m_DRVWejeIHITUKCPwBO8VkUstJ-faQIzMcykmaG6fE&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTam1PVnK2-R-wrifCrMiXuKsTntcEG6PZlO6rRMywsLRSCMwZj0ollWRR-hnBUR4Xf9ec&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYvoIGN6x55-IlOjj0WYry18c4H6NL7ceMKODOlFrBCzYNmfuOFhfqVVQsWmUhT88LDqE&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWJk272KVXL49VMqnDU9o9R6snA3yeT0utGvNtRC28WEUr4mENNP_ufCd-LDMNSFJJTX0&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXf2u18vWpxWTbbsYfmR9GcjuHc_uc35AFxxKORm1gvUftkOVtokGXkrPEdDAtEr5Om8A&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTGfPBsovrWuYCDdEX7VWyTnmZ9nuvNtgwGDxEiEcwrFwGQzb5aP_D8XvYwT2TyhnPDH3U&usqp=CAU",
                //"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTTfNNdMVgk8hZdiMSduQjaTMZOAGVnE5YjNJu_ni_qRuBcHvFXk_pAW1sFeMOeh3OuHfg&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSaCUedM-Ae0GUwQKq5oAreG6f2nZf-vO2_pPhWEISglLSAtQeFKupuZJTbgAesRzX33Lg&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQmrVmLOZ8I3MIteqRQNH8WS0FXQSqOfJEBb4Y3mnIU9uo1itAyJ79eSA1BbYpkJyrs6sE&usqp=CAU",
                "https://www.barkbusters.co.uk/files/dog-breed/rottweiler/rottweiler-dog.webp"

            )

            15 -> listOf(
                "https://cdn.britannica.com/46/233846-050-8D30A43B/Boxer-dog.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtFjXwXdrFZtCoYea7qKHALpdazlZCiit7vxV2-R2diQR_eib9O_g3SaXYYFQQqoVrl8I&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSteFqcbNGKk4hkhY8dji7aoxY4aa0vsWpwVRmy-nR79z04uRNPnWEbA7y8-LpHb8d0BDo&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTEBoU2s3KYzxXDigyrZXic3s6hEf9mh5QpzQ2wZhmOT_vbo9TOTR4uXTlgd_G6pGktPk&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSkR0K2Zyo7Hl_JCpbvXpU2XQ-y4lwqWql5LgWgyouggl_mxArB8Oxym5rtXRIgMxyFLso&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRjG-RD-qRI3QU3gwM2ApbCGID84FsofXwh1frdoWghc0i2NAjmaf78b0o6sLoInVuFsFI&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRrgVgIS6NknT2A3IjDNbeIQlXsAhIYKXgeJo5rh2HZTl_X6M2e_0z01K9hq1xph-z4JlA&usqp=CAU",
                "https://cdn.wamiz.fr/cdn-cgi/image/format=auto,quality=80,width=1200,height=675,fit=cover/animal/breed/dog/adult/6707e69e15df6623344281.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWFhXAn55g1PWbes_aHizGhxICbShhEmb8c_jG4C3cnozftjWcOsIH2ebbbG4vk2sjaP4&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRkLq1Z9-w7QyGs8ivYer_csUdaYNn0LW2dybqa0xR7jIV7hnvUqoPXVPj55WimOo2lAWk&usqp=CAU"


            )

            else -> emptyList()
        }

    }


    fun UsersList(): List<User> {
        return users
    }

}