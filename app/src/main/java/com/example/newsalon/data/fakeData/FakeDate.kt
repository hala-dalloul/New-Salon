package com.example.newsalon.data.fakeData

import com.example.newsalon.R
import com.example.newsalon.domain.models.Banner
import com.example.newsalon.domain.models.CartItem
import com.example.newsalon.domain.models.Category
import com.example.newsalon.domain.models.Product
import com.example.newsalon.domain.models.User

object FakeData {
    val categories = listOf(

        Category(1,"Hair",(R.drawable.image_hear_care).toString()),
        Category(2,"Makeup",(R.drawable.image_makeup).toString()),
        Category(3,"Skin Care",(R.drawable.image_creem).toString()),
        Category(4,"Perfume",(R.drawable.image_perfum).toString()),
        Category(5,"Tools",(R.drawable.image_spong).toString()),
        Category(6,"Creams",(R.drawable.image_creem).toString()),
        Category(7,"Nails",(R.drawable.image_nailes_color).toString()),
        Category(10,"Body",(R.drawable.image_body_care).toString()),
        Category(13,"Lip Care",(R.drawable.image_lipsticks_set).toString()),
        Category(14,"Brushes",(R.drawable.image_prush).toString()),

    )

    val products = listOf(

        Product(1,"Hair Dryer",120.0,(R.drawable.image_hear_care).toString(),"Professional hair dryer","Hair",false,0.3),
        Product(2,"Face Cream",45.0,(R.drawable.image_creem).toString(),"Skin care cream","Skin Care",false),
        Product(3, "Perfume Rose", 90.0,(R.drawable.image_perfum).toString(), "Rose perfume", "Perfume", false, 0.2),
        Product(4,"Makeup Brush",20.0,(R.drawable.image_prush).toString(),"Soft brush","Tools",false,0.4),
        Product(5,"Nail Polish",15.0,(R.drawable.image_nailes_color).toString(),"Red nail polish","Nails",false),
        Product(6,"Body Lotion",40.0,(R.drawable.image_creem).toString(),"Body lotion","Body",false),
        Product(7,"Lipstick",30.0,(R.drawable.image_lipsticks_set).toString(),"Matte lipstick","Makeup",false),

    )

    val users = listOf(
        User(1,"5991234","User1","user1@email.com","https://picsum.photos/200?21"),
        User(2,"5992345","User2","user2@email.com","https://picsum.photos/200?22"),
        User(3,"5993456","User3", "user3@email.com", "https://picsum.photos/200?23"),
        User(4,"5994567","User4","user4@email.com","https://picsum.photos/200?24"),
        User(5,"5995678","User5","user5@email.com","https://picsum.photos/200?25"),
        User(6,"5996789","User6","user6@email.com","https://picsum.photos/200?26"),
        User(7,"5671234","User7","user7@email.com","https://picsum.photos/200?27"),
        User(8,"5672345","User8","user8@email.com","https://picsum.photos/200?28"),
        User(9,"5673456","User9","user9@email.com","https://picsum.photos/200?29"),
        User(10,"5674567","User10","user10@email.com","https://picsum.photos/200?30"),
        User(11,"5675678","User11","user11@email.com","https://picsum.photos/200?31")
    )

    val banners = listOf(

        Banner(1,(R.drawable.image_lipsticks_set).toString()),
        Banner(2,(R.drawable.image_lipsticks_set).toString()),
        Banner(3,(R.drawable.image_lipsticks_set).toString()),
        Banner(4,(R.drawable.image_lipsticks_set).toString()),
        Banner(5,(R.drawable.image_lipsticks_set).toString()),
        Banner(6,(R.drawable.image_lipsticks_set).toString()),
    )

    val cartItems = listOf(

        CartItem(products[0],1),
        CartItem(products[1],2),
        CartItem(products[2],1),
        CartItem(products[3],1),
        CartItem(products[4],3),
        CartItem(products[5],1),
        CartItem(products[6],2)
    )

}