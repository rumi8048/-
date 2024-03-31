from django.contrib import admin
from django.urls import path
from .views import signup, login
urlpatterns = [
    path('signup/',signup, name='signup'),
    path('signup/success',login,
    name='login'),
]
