from django.contrib import admin
from django.urls import path
from .views import login, logout
urlpatterns = [
    path('login/',login, name='login'),
    path('login/success',logout,
    name='logout'),
]
