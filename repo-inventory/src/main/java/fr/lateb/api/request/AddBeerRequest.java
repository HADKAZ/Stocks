package fr.lateb.api.request;

public record AddBeerRequest(String barcode ,String name , String format ,String type , String brewery ,float alchoolDeg) {
}
