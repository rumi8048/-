from django import forms
from django.contrib.auth.forms import UserCreationForm
from .models import CustomUser,Blog



class SignUpForm(UserCreationForm):
    user_id = forms.CharField(max_length=50, required=True)  # 사용자 ID 필드 추가

    class Meta:
        model = CustomUser
        fields = (
            "user_id",
            "username",
            "email",
            "major",
            "nickname",
            "password1",
            "password2",
        )

class LoginForm(forms.Form):
    user_id = forms.CharField(label="User ID")
    password = forms.CharField(label="Password", widget=forms.PasswordInput)

class ProfileForm(forms.ModelForm):
    class Meta:
        model = CustomUser
        fields = ['username', 'email', 'major', 'nickname','user_id']

class BlogForm(forms.ModelForm):
    class Meta:
        model = Blog
        fields = ['title', 'body', 'mainphoto']