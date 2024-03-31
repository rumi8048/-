from django.db import models
from django.contrib.auth.models import User

class Login(User):
    ID=models.CharField(max_length=15,primary_key=True)
    password=models.CharField(max_length=15)
