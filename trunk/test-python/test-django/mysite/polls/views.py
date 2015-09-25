# from django.shortcuts import render
from django.http import HttpResponse, Http404
from .models import Question
from django.template import RequestContext, loader
from django.shortcuts import render
# Create your views here.


def index(request):
    latest_question_list = Question.objects.order_by('-pub_date')[:5]
    template = loader.get_template('polls/index.html')
    # output = ', '.join([p.question_text for p in latest_question_list])
    # return HttpResponse("Hello, world. You're at the polls index.")
    # return HttpResponse(output)
    context = RequestContext(request, {
        'latest_question_list': latest_question_list,
    })
    return HttpResponse(template.render(context))


def detail(request, question_id):
    # return HttpResponse("You're looking at question %s." % question_id)
    try:
        question = Question.objects.get(pk=question_id)
    except Question.DoesNotExist:
        raise Http404("Question does not exist")
    return render(request, 'polls/detail.html', {'question': question})


def json(request):
    from django.utils import timezone
    # http://stackoverflow.com/questions/25659178/serialize-datetime-datetime-object-as-json
    # json on timezone
    q = Question(question_text="What's new?: test json", pub_date=timezone.now().isoformat())
    return HttpResponse(q.to_json())

