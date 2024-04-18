from django.http import HttpResponse
from django.shortcuts import render,redirect
from django.contrib.auth import login,authenticate
from .forms import BlogForm, ProfileForm, SignUpForm, LoginForm 
from django.contrib import messages
from .models import CustomUser, Post
from django.contrib.auth.decorators import login_required
from .models import Blog
from .models import models



def signup(request):
    if request.method == 'POST':
        form=SignUpForm(request.POST)
        if form.is_valid():
            user=form['user'].save()
            profile=form['profile'].save(commit=False)
            profile.user=user
            profile.save()
            user_id = form.cleaned_data.get("user_id")
            username = form.cleaned_data.get("username")
            password = form.cleaned_data.get("password")
            email = form.cleaned_data.get("email")
            nickname = form.cleaned_data.get("nickname")
            user = authenticate(user_id=user_id,username=username, password=password,email=email,nickname=nickname)
            if user is not None:
        # 인증에 성공한 경우에만 로그인 후 리다이렉트
                login(request, user)
            return redirect('home')

    else:
        form=SignUpForm()
    return render(request,'signup.html',{'form':form})


def logout(request):
    return render(request,'home.html')


def load_login_form(request):
    """
    로그인 폼을 불러오는 함수
    """
    if request.method == 'POST':
        form = LoginForm(request.POST)
    else:
        form = LoginForm()
    return render(request, 'login_view.html', {'form': form})

def login_view(request):
    """
    로그인 페이지를 렌더링하는 함수
    """
    if request.method == "POST":
        form = LoginForm(request.POST)
        if form.is_valid():
            user_id = form.cleaned_data.get("user_id")
            password = form.cleaned_data.get("password")
            user = authenticate(request, user_id=user_id, password=password)
            if user is not None:
                login(request, user)
                return redirect("login_success")
            else:
                messages.error(request, "일치하는 회원정보가 없습니다. 다시 시도해주세요.")
    else:
        form = LoginForm()

    return render(request, "login_success.html", {"user": request.user})


@login_required
def login_success(request):
    try:
        custom_user = CustomUser.objects.get(user_id=request.user.id)
        custom_user = CustomUser.objects.get(username=request.user.username)
        custom_user = CustomUser.objects.get(user_major=request.user.major)
        custom_user = CustomUser.objects.get(user_nickname=request.user.nickname)
        custom_user = CustomUser.objects.get(user_email=request.user.email)
    except CustomUser.DoesNotExist:
        custom_user = None

    return render(request, 'login_success.html', {'user': request.user})

def profile(request):
    # 세션에서 사용자 ID 가져오기
    user = request.user
    profile_form = ProfileForm(instance=user)

    if request.method == 'POST':
        profile_form = ProfileForm(request.POST, instance=user)
        if profile_form.is_valid():
            profile_form.save()
            return redirect('profile')

    return render(request, 'profile.html', {'profile_form': profile_form})

 
def home(request):
    blogs = Blog.objects
    return render(request, 'home.html', {'blogs' : blogs})
  
def new(request):
    return render(request, 'new.html')

def create(request):
    if request.method == 'POST':
        form = BlogForm(request.POST, request.FILES)
        if form.is_valid():
            post = form.save(commit=False)
            post = Blog()
            post.title = request.POST['title']
            post.body = request.POST['body']
            post.mainphoto = request.FILES.get('mainphoto')  # mainphoto 속성에 이미지 파일 할당
            post.save()
            return redirect('login_success')
    else:
        form = BlogForm()
    return render(request, 'new.html', {'form': form})

def blog(request):
    postlist = Post.objects.all()
    return render(request, 'blog.html', {'postlist':postlist})

def post(request, pk):
    # 게시글(Post) 중 pk(primary_key)를 이용해 하나의 게시글(post)를 검색
    post = Post.objects.get(pk=pk)
    # posting.html 페이지를 열 때, 찾아낸 게시글(post)을 post라는 이름으로 가져옴
    mainphoto = models.ImageField(blank=True, null=True)
    return render(request, 'post.html', {'post':post})