<?php

use Illuminate\Http\Request;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/
Route::group(['prefix' => 'products'], function() {
    Route::post('insertar', 'ProductController@insertar');
    Route::post('actualizar', 'ProductController@actualizar');
    Route::delete('eliminar/{id}', 'ProductController@eliminar');
    Route::get('/', 'ProductController@listar');
    Route::get('/{id}', 'ProductController@mostrar');
});

Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});
