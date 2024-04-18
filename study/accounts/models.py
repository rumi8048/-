from django.db import models
from django.contrib.auth.models import AbstractUser


class CustomUser(AbstractUser):
    major = models.CharField(max_length=100)
    nickname = models.CharField(max_length=100)
    user_id = models.CharField(max_length=50, unique=True)  # 사용자 정의 ID 필드


class Blog(models.Model):
    title = models.CharField(max_length=200)
    body = models.TextField()
    mainphoto = models.ImageField(upload_to='blog_photos/', blank=True, null=True)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __str__(self):
        return self.title

class Post(models.Model):
    postname = models.CharField(max_length=50)
    contents = models.TextField()
    def __str__(self):
        return self.postname