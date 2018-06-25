import { Component, OnInit  } from '@angular/core';
import { BookService } from '../../service/book/book.service';
import { Book } from '../../model/book.model';
import { MatTableDataSource, MatDialog } from '@angular/material';

import { AddComponent } from './../../dialogs/add/add.component';
import { EditComponent } from './../../dialogs/edit/edit.component';
import { DeleteComponent } from './../../dialogs/delete/delete.component';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  books: Book[] = [];
  dataSource: MatTableDataSource<Book>;
  displayedColumns = ['bookTitle', 'language', 'catgName', 'publicationYear', 'actions'];

  constructor(private _bookService: BookService, private dialog: MatDialog,) {}

  ngOnInit() {
    this.getAllArticles();
  }

  //Fetch all articles
  getAllArticles() {
    this._bookService.getAvailableBooks().subscribe(
    data => {
      if (data) {
        this.books = data;
        this.dataSource = new MatTableDataSource(this.books);
      }
    }
    );  
    console.log(this.books);
  }

  addElement() {
    this.books.push(this._bookService.getEmptyRow());
    this.dataSource = new MatTableDataSource(this.books);
  }

  addNew(book: Book) {
    const dialogRef = this.dialog.open(AddComponent, {
      data: {book: book }
    });
  }

}
