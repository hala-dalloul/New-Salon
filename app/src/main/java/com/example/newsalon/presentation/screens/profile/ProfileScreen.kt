package com.example.newsalon.presentation.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.newsalon.data.fakeData.FakeData
import com.example.newsalon.presentation.navigation.BottomNavFun
import com.example.newsalon.presentation.screens.components.BeautyTopBar
import com.example.newsalon.presentation.screens.components.EditProfileBottomSheet
import com.example.newsalon.presentation.theme.BeautyAppTheme
import com.example.newsalon.presentation.theme.BeautyRed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavHostController, viewModel: ProfileViewModel = viewModel()) {
    var showEditSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val person = viewModel.userState

    if (showEditSheet) {
        ModalBottomSheet(
            onDismissRequest = { showEditSheet = false },
            sheetState = sheetState,
            containerColor = Color.White,
            dragHandle = { BottomSheetDefaults.DragHandle() }
        ) {
            EditProfileBottomSheet(
                onDismiss = { showEditSheet = false },
                initialName = person?.name ?: "",
                initialPhone = person?.phone ?: "",
                initialEmail = person?.email ?: "",
                onDone = { name, phone, email ->
                    showEditSheet = false
                }
            )
        }
    }
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        BeautyTopBar(
            text = "Account", textAlign = TextAlign.Center
        )
    }, bottomBar = {
        BottomNavFun(navController)
    }) { padding ->
        BeautyAppTheme {
            Column(Modifier.padding(padding)) {
                Row(Modifier.padding(horizontal = 28.dp, vertical = 24.dp)) {
                    ConstraintLayout(
                        modifier = Modifier
                            .size(90.dp)
                    ) {
                        val (personImage, cameraIcon) = createRefs()
                        Image(
                            painter = painterResource(com.example.newsalon.R.drawable.person),
                            contentDescription = "person image",
                            modifier = Modifier
                                .size(90.dp)
                                .clip(RoundedCornerShape(15.dp))
                                .constrainAs(personImage) {
                                    top.linkTo(parent.top)
                                    bottom.linkTo(parent.bottom)
                                    end.linkTo(parent.end)
                                    start.linkTo(parent.start)
                                    width = Dimension.fillToConstraints
                                    height = Dimension.fillToConstraints
                                }
                        )
                        IconButton(
                            onClick = {},
                            modifier = Modifier
                                .padding(top = 5.dp, start = 10.dp)
                                .clip(RoundedCornerShape(100.dp))
                                .background(color = BeautyRed)
                                .padding(5.dp)
                                .size(20.dp)
                                .constrainAs(cameraIcon) {
                                    bottom.linkTo(parent.bottom)
                                    end.linkTo(parent.end)
                                }) {
                            Icon(
                                painter = painterResource(com.example.newsalon.R.drawable.icon_camera),
                                contentDescription = "camera",
                                modifier = Modifier.fillMaxSize(),
                                tint = Color.White
                            )
                        }
                    }

                    Column(Modifier.padding(start = 8.dp)) {
                        Text(
                            text = person?.name ?: "Not Hava Name",
                            color = Color(0xff070707),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W400
                        )
                        Text(
                            text = person?.phone ?: "Not Hava Phon",
                            modifier = Modifier.padding(top = 12.dp),
                            color = Color(0xff808080),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W400
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = person?.email ?: "Not Hava Email",
                                color = Color(0xff808080),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W400
                            )
                            IconButton(onClick = {showEditSheet = true}, modifier = Modifier.size(24.dp)) {
                                Icon(
                                    modifier = Modifier.fillMaxSize(),
                                    imageVector = Icons.Filled.Edit,
                                    contentDescription = "Edit your information",
                                    tint = Color(0xff063BFA)
                                )
                            }
                        }
                    }
                }

                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .border(2.dp, color = Color(0xffE3E3E3), shape = RoundedCornerShape(5.dp))
                )

                Row(Modifier
                    .padding(start = 28.dp, top = 12.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painterResource(com.example.newsalon.R.drawable.icon_my_order),
                        contentDescription = "my order",
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .size(15.dp)
                    )
                    Text("My Order", fontSize = 14.sp, fontWeight = FontWeight.W400, color = Color(0xff051320))
                }
                Row(Modifier
                    .padding(start = 28.dp, top = 4.dp, bottom = 4.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painterResource(com.example.newsalon.R.drawable.icon_payment),
                        contentDescription = "payment",
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .size(15.dp)
                    )
                    Text("payment method", fontSize = 14.sp, fontWeight = FontWeight.W400, color = Color(0xff051320))
                }
                Row(Modifier
                    .padding(start = 28.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painterResource(com.example.newsalon.R.drawable.icon_shapping_address),
                        contentDescription = "shipping address",
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .size(15.dp)
                    )
                    Text("Shipping address", fontSize = 14.sp, fontWeight = FontWeight.W400, color = Color(0xff051320))
                }

                Spacer(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 15.dp)
                        .height(1.dp)
                        .fillMaxWidth()
                        .border(2.dp, color = Color(0xffE3E3E3), shape = RoundedCornerShape(5.dp))

                )

                Row(Modifier
                    .padding(start = 28.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painterResource(com.example.newsalon.R.drawable.icon_help),
                        contentDescription = "fqa",
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .size(15.dp)
                    )
                    Text("FQA", fontSize = 14.sp, fontWeight = FontWeight.W400, color = Color(0xff051320))
                }
                Row(Modifier
                    .padding(start = 28.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painterResource(com.example.newsalon.R.drawable.icon_invite_person),
                        contentDescription = "invite",
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .size(15.dp)
                    )
                    Text("invite friends", fontSize = 14.sp, fontWeight = FontWeight.W400, color = Color(0xff051320))
                }
                Row(Modifier
                    .padding(start = 28.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painterResource(com.example.newsalon.R.drawable.icon_settings),
                        contentDescription = "working bag",
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .size(15.dp)
                    )
                    Text("settings", fontSize = 14.sp, fontWeight = FontWeight.W400, color = Color(0xff051320))
                }

                Spacer(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 15.dp)
                        .height(1.dp)
                        .fillMaxWidth()
                        .border(2.dp, color = Color(0xffE3E3E3), shape = RoundedCornerShape(5.dp))

                )

                Row(Modifier
                    .padding(start = 28.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painterResource(com.example.newsalon.R.drawable.icon_log_out),
                        contentDescription = "log out",
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .size(15.dp)
                    )
                    Text("Log out", fontSize = 14.sp, fontWeight = FontWeight.W400, color = Color(0xff051320))
                }
            }

        }
    }
}

@Preview
@Composable
fun PreviewFun() {
    BeautyAppTheme {
        ProfileScreen(rememberNavController())
    }
}