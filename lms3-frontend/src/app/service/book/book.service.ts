import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders  }   from '@angular/common/http';
import { Observable }   from 'rxjs';
import { Book } from '../../model/Book.model';
import { Category } from '../../model/Category.model';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  // Temporarily stores data from dialogs
  dialogData: any;

  constructor(private http: HttpClient) {}
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private booksUrl = 'http://localhost:8080/lms3/example/v1/books';

  getAvailableBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(this.booksUrl);
  }

  getBookCategories(): Observable<Category[]> {
    return this.http.get<Category[]>(this.booksUrl + "/categories");
  }

  addBook(book: any){
    this.dialogData = book;
    console.log(book);

    //const headers = new HttpHeaders().set('content-type', 'application/json'); 

    let book1 = this.getEmptyRow();

    book1.bookTitle = book.bookTitle;
    book1.category.id = book.category;
    book1.language = book.language;
    book1.publicationYear = book.publicationYear;
    
    return this.http.post<Book>(this.booksUrl+'/addBook', book1);

  }

  getEmptyRow(): Book{
    var newBook: Book = {
      id: 0,
      bookTitle: '',
      language: '',
      actualCopies: 0,
      currentCopies: 0,
      category: 
          {
                  id: 0,
                  catgName: ''
          },
      publicationYear: null
  };

  return newBook;
  
  }

  private extractData(res: Response) {
    let body = res.json();
          return body;
      }

  private handleError(error: any): Promise<Book[]> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}