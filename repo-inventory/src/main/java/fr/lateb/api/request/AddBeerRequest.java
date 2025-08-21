package fr.lateb.api.request;

public record AddBeerRequest(String barcode ,String name ,String description ,  String formatName , float quantity,String type , String brewery ,float alchoolDeg) {
}
