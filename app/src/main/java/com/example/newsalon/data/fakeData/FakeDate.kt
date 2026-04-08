package com.example.newsalon.data.fakeData

import androidx.compose.runtime.mutableStateListOf
import com.example.newsalon.R
import com.example.newsalon.domain.models.Banner
import com.example.newsalon.domain.models.CartItem
import com.example.newsalon.domain.models.Category
import com.example.newsalon.domain.models.Product
import com.example.newsalon.domain.models.User

object FakeData {
    val categories = listOf(

        Category("1","Skin creams",(R.drawable.image_creem).toString()),
        Category("2","Nails Product",(R.drawable.image_nailes_color).toString()),
        Category("3","Perfume",(R.drawable.image_perfum).toString()),
        Category("4","Makeup",(R.drawable.image_makeup).toString()),
        Category("5","Hair care tools",(R.drawable.image_hear_care).toString()),
        Category("6","Body tools",(R.drawable.image_body_care).toString()),
        Category("7","Prushes",(R.drawable.image_prush2).toString()),
        Category("8","Hair care Product",(R.drawable.shampo).toString()),

    )

    val products = listOf(

        Product(1,"Hair Dryer",120.0,(R.drawable.image_hear_care).toString(),"Professional hair dryer","5",false,0.3,40),
        Product(2,"Face Cream",45.0,(R.drawable.image_creem).toString(),"Skin care cream","1",false,count = 20),
        Product(3, "Perfume Rose", 90.0,(R.drawable.image_perfum).toString(), "Rose perfume", "3", false, 0.2, 70),
        Product(4,"Makeup Brush",20.0,(R.drawable.image_prush).toString(),"Soft brush","Tools",true,0.4),
        Product(5,"Nail Polish",15.0,(R.drawable.image_nailes_color).toString(),"Red nail polish","2",false, count = 10),
        Product(6,"Body Lotion",40.0,(R.drawable.image_creem).toString(),"Body lotion","6",false),
        Product(7,"Lipstick",30.0,(R.drawable.image_lipsticks_set).toString(),"Matte lipstick","4",false , count = 20),

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

    val cartItems = mutableStateListOf(

        CartItem(products[0],1),
        CartItem(products[1],2),
        CartItem(products[2],1),
        CartItem(products[3],1),
        CartItem(products[4],3),
        CartItem(products[5],1),
        CartItem(products[6],2)
    )

}