# PagingLib
Paging Library  android
You are here: Home / Android Application Development / Android Paging Library Tutorial using Retrofit
Android Paging Library Tutorial using Retrofit
August 4, 2018 by Belal Khan 16 Comments


Hi folks, after android Jetpack we have many new things to learn. So here is Android Paging Library Tutorial for you. Android Paging Library is an important component of Android Jetpack.
Many app displays a large set of data to the users, for example consider the Amazon App, it shows you the list of products, and the app has too many products, but it do not loads all the product at once, it shows you some products, as soon as you reaches the last item of the product list it loads more products. This is called paging. 
Contents [hide]
1 Android Paging Library Tutorial – Video
2 Why use Paging?
2.1 Disadvantages of not using Paging
2.2 Advantages of using Paging
3 Android Paging Library
4 Pre-Requisites
5 Backend API
6 Android Paging Library Tutorial
6.1 Creating a new project
6.2 Adding Dependencies
6.3 Creating Model Class
6.4 Creating Retrofit Singleton Class
6.5 Creating API
6.6 Creating RecyclerView
6.7 Creating PagedListAdapter
6.7.1 What is PagedListAdapter?
6.8 Creating Item Data Source
6.9 Creating Item Data Source Factory
6.10 Creating ViewModel
6.11 Displaying the Paged List
7 Android Paging Library Tutorial Source Code
7.1 Sharing is Caring:
7.2 Related
Android Paging Library Tutorial – Video
If you don’t like reading text and want a visual experience, then here is a complete step by step video series for understanding Android Paging Library.


Why use Paging?
Assume you have more than 1000 items for your list that you are fetching from a backend server. Here are the cons if you are fetching everything at once.

Disadvantages of not using Paging
User do not see all the items at once, but you are fetching everything at once, so it will consume more bandwidth uselessly.
Creating a large List at once uses more system resources resulting in a lagging app and bad user experience.
Advantages of using Paging
You will only load a small chunk from your large data set, it will consume less bandwidth.
The app will use less resources resulting in a smooth app and nice user experience.
Android Paging Library
Android paging library is a component of android jetpack. Remember it is not available by default so we need to add it. It helps us to load data gradually and gracefully in our application’s RecyclerView.

In this Android Paging Library Tutorial I will not tell you about the theoretical things about the library. Because to know this thing you can visit the official documentation. Instead of discussing the theoretical bla bla bla we will learn implementing the library in our application, as the official documentation might confuse you.
