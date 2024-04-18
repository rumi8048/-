from django.contrib import admin
from django.urls import path
from .views import home,signup,load_login_form,logout,login_success,login_view,new,create,blog,post

from django.conf.urls.static import static
from django.conf import settings


urlpatterns = [
    path('',home, name='home'),
    path('signup/',signup, name='signup'),
    path('logout/',logout,name="logout"),
    path('load_login_form/',load_login_form,name="load_login_form"),
    path('login_view/',login_view,name="login_view"),
    path('login_success/',login_success,name="login_success"),
    path('new/', new, name='new'),
    path('create/', create, name='create'),
    path('blog/',blog),
    path('post/',post),
    

]
urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)