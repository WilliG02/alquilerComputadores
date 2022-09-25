function leerClientes(){
// funcion get
    $.ajax({
        url: 'https://gd19d53bd2c9c62-computer.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client',
        type: 'GET',
        dataType: 'json',

        success: function(clientes){
            let cs=clientes.items;
            $("#listaClientes").empty();
            for(i=0;i<cs.length;i++){
                $("#listaClientes").append(cs[i].id + "</b> " + "<b>" + cs[i].name + "</b> " + cs[i].email + "</b> "+ cs[i].age);
                $("#listaClientes").append("<button onclick='borrarCliente("+cs[i].id+")'>Borrar</button><br>");
            }
        },
        error : function(xhr, status){
            alert('ha sucedido un problema');
        }
    });
}

function guardarCliente(){
    let idCliente = $("#idCliente").val();
    let nombre = $("#nombreCliente").val();
    let mail = $("#correoCliente").val();
    let edad = $("#edadCliente").val();

    let data={
        id:idCliente,
        name:nombre,
        email:mail,
        age:edad
    };
    let dataToSend=JSON.stringify(data) //convierto en una cadena de texto
    console.log(dataToSend);

    $.ajax({
        url: 'https://gd19d53bd2c9c62-computer.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client',
        type: 'POST',
        //dataType: 'json',
        data:dataToSend,
        contentType:'application/json',
        success: function(clientes){
            $("#idCliente").val("");
            $("#nombreCliente").val("");
            $("#correoCliente").val("");
            $("#edadCliente").val("");
        },
        error : function(xhr, status){
        //    alert('ha sucedido un problema');
        },
        complete: function(){ 
            leerClientes()
        }
    });
}

function editarCliente(){
    let idCliente = $("#idCliente").val();
    let nombre = $("#nombreCliente").val();
    let mail = $("#correoCliente").val();
    let edad = $("#edadCliente").val();

    let data={
        id:idCliente,
        name:nombre,
        email:mail,
        age:edad
    };
    let dataToSend=JSON.stringify(data) //convierto en una cadena de texto
    console.log(dataToSend);

    $.ajax({
        url: 'https://gd19d53bd2c9c62-computer.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client',
        type: 'PUT',
        //dataType: 'json',
        data:dataToSend,
        contentType:'application/json',
        success: function(clientes){
            $("#idCliente").val("");
            $("#nombreCliente").val("");
            $("#correoCliente").val("");
            $("#edadCliente").val("");
        },
        error : function(xhr, status){
        //    alert('ha sucedido un problema');
        },
        complete: function(){ 
            leerClientes()
        }
    });

}

function borrarCliente(idCliente){
    let data={
        id:idCliente,
    };

    let dataToSend=JSON.stringify(data) //convierto en una cadena de texto
    console.log(dataToSend);

    $.ajax({
        url: 'https://gd19d53bd2c9c62-computer.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client',
        type: 'DELETE',
        //dataType: 'json',
        data:dataToSend,
        contentType:'application/json',
        success: function(clientes){
            $("#idCliente").val("");
            $("#nombreCliente").val("");
            $("#correoCliente").val("");
            $("#edadCliente").val("");
        },
        error : function(xhr, status){
        //    alert('ha sucedido un problema');
        },
        complete: function(){ 
            leerClientes()
        }
    });
}
