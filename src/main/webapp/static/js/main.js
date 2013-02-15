var version = '1.0.5';

function init()
{
    bindEnter();
    refreshData();
}

function bindEnter()
{
    $('#label').keydown(function(e)
    {
        if(e.which == 13)
        {
            createTaskFromUi();
        }
    });
}


function createTaskFromUi()
{
    var task = {};
    task['label'] = $('#label').val();
    createTask(task);
}

function createTask(task)
{
    var type = "POST";
    var url = "/site/json/create";
    // The key needs to match your method's input parameter (case-sensitive).

    $.ajax({
            type: "POST",
            url: url,
            data: JSON.stringify(task),
            dataType: "json",
            contentType: "application/json"
        }).done(refreshData);
}

function refreshData()
{
    var url = "/site/json/all";
    $.getJSON(url, populateTaskList);  
}

function populateTaskList(data)
{
    $('#header-count').html(data.length + ' Task(s) ' + version);

    $('#list-task').empty();
    
    $.each(data, function(key, task) {
        console.log(task);        
        $('#list-task').append(bullet(task));
        
    });
}

function bullet(task)
{
    var html = '<li>' + task.label + '<button onclick="deleteTask(' + task.id + ')">delete</button></li>'
    return html;
}

function deleteTask(id)
{
    var type = "POST";
    var url = "/site/json/delete";
    // The key needs to match your method's input parameter (case-sensitive).
    
    var task = {};
    task['label'] = 'dummy';
    task['id'] = id;
    console.log('updated');
    
    function onError(jqXHR, textStatus, errorThrown )
    {
        alert(jqXHR);
        alert(textStatus);
        alert(errorThrown);
    }

    $.ajax({
            type: "POST",
            url: url,
            data: JSON.stringify(task),
            dataType: "json",
            contentType: "application/json"
        }).done(refreshData).error(onError);
}

$(init);