package com.brightly.service;

import com.brightly.*;
import com.brightly.entity.BookEntity;
import com.google.protobuf.Empty;
import com.google.protobuf.Int32Value;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class BookServiceGrpc implements BookService {

   public BookEntity convertBookToBookEntity(Book book)
   {
       BookEntity entity=new BookEntity();
       entity.setBookId(book.getBookId());
       entity.setBookName(book.getBookName());
       entity.setAuthorName(book.getAuthorName());
       entity.setPages(book.getPages());
       return entity;
   }
    public Book convertBookEntityToBook(BookEntity entity)
    {
       return  Book.newBuilder()
                .setBookId(entity.getBookId())
                .setPages(entity.getPages())
                .setBookName(entity.getBookName())
                .setAuthorName(entity.getAuthorName()).build();
    }


    @Override
    public Uni<Book> createBook(Book book) {
        TempDp.bookList.add(convertBookToBookEntity(book));
        return Uni.createFrom().item(book);
    }

    @Override
    public Uni<Book> deleteBookById(Int32Value bookId) {
      List<BookEntity> bookEntityList= TempDp.bookList;
        final BookEntity[] bookToReturn = {null};
      bookEntityList=bookEntityList.stream()
              .filter(entity-> {
                  if(entity.getBookId()!=bookId.getValue())
                  {
                      return true;
                  }
                  else {
                      bookToReturn[0] =entity;
                      return false;
                  }
              })
              .collect(Collectors.toList());
        return Uni.createFrom().item(convertBookEntityToBook( bookToReturn[0]));
    }

    @Override
    public Uni<ListBookResponse> deleteBooks(Empty request) {

        List<BookEntity> entities = TempDp.bookList;
        List<Book> list = new ArrayList<>();
        for(BookEntity ent : entities){
            list.add(convertBookEntityToBook(ent));
        }
        ListBookResponse obj = ListBookResponse.newBuilder().addAllBook(list).build();
        TempDp.bookList=null;
        return Uni.createFrom().item(obj);
    }

    @Override
    public Uni<Book> updateBook(UpdateBookMessage request) {
     TempDp.bookList=(ArrayList<BookEntity>) TempDp.bookList.stream().map(bookEntity -> {
           if(bookEntity.getBookId()==request.getBookId().getValue())
           {
               return convertBookToBookEntity(request.getBook());
           }
           return  bookEntity;
       }).collect(Collectors.toList());
        return Uni.createFrom().item(request.getBook());
    }

    @Override
    public Uni<Book> getBookById(Int32Value request) {
       Uni<Book> book=null;
        for (BookEntity bookEntity : TempDp.bookList) {
            if (bookEntity.getBookId() == request.getValue())
                book = Uni.createFrom().item(convertBookEntityToBook(bookEntity));
        }
        return book;
    }

    @Override
    public Uni<ListBookResponse> getAllBooks(Empty request) {
       List<BookEntity> entities = TempDp.bookList;
       List<Book> list = new ArrayList<>();
        for(BookEntity ent : entities){
            list.add(convertBookEntityToBook(ent));
        }
       ListBookResponse obj = ListBookResponse.newBuilder().addAllBook(list).build();
        return Uni.createFrom().item(obj);
    }
}
