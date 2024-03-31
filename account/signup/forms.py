from django import forms
from .models import CustomUser

class SignUpForm(forms.ModelForm):
    class Meta:
        model=CustomUser
        fields=('ID','email','name','major','nickname','password','phoneNumber')