export class Factura{
    CUFE:string;
    fecha_expedicion: Date;
    fecha_vencimiento: Date;
    valor_neto:number;
    total_descuento:number;
    estado:boolean;
    firma:string;
    empresa_NIT:number;
    rango_numeracion:number;
    cliente_numero_documento:number;    
}
