package com.ranulfoneto.workshopmongo.dtos;

import java.util.Date;

public record CommentDTO(String text, Date date, AuthorDTO author) {

}