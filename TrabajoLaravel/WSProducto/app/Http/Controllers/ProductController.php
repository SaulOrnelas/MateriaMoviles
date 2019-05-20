<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use App\Product;

class ProductController extends Controller
{
    public function insertar(Request $request){
        
        $rules = [
            'nombre' => 'required',
            'precio' => 'required',
            'descripcion' => 'required'
        ];
        $datos = $request->all();
        $errores = $this->validate($datos,$rules);
        if(count($errores)>0){
            return $this->error($errores);
        }
        $products = Product::create($datos);
        return $this->success($products);
    }

    public function actualizar(Request $request){   
        $array = $request->all();
        $data = Product::find($request->id);
        if(!$data) {
            return $this->error(["Objeto no encontrado"]);
        }
        $data->update($array);
        return $this->success($data);
    }

    public function eliminar($id){
        $data = Product::find($id);
        if(!$data) {
            return $this->error(["Objeto no encontrado"]);
        }
        
        $data->delete();
        return $this->success(["objeto eliminado correctamente"]);
    }

    public function listar(){
        $data = Product::get();
        return $this->success($data);
    }

    public function mostrar($id){
        $data = Product::find($id);
        if(!$data) {
            return $this->error(["Objeto no encontrado"]);
        }
        return $this->success($data);
    }
}
