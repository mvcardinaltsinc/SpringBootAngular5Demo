import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Component, Inject, OnInit} from '@angular/core';
import { BookService } from '../../service/book/book.service';
import {FormControl, Validators} from '@angular/forms';
import {Book} from '../../model/book.model';
import {Category} from '../../model/category.model';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  category: Category[];

  constructor(public dialogRef: MatDialogRef<AddComponent>,
    @Inject(MAT_DIALOG_DATA) public book: Book,
    public dataService: BookService) { }

    ngOnInit() {
      this.dataService.getBookCategories().subscribe(
        data => {
          if (data) {
            this.category = data;
            console.log(data);
          }
        }
        );
    }

formControl = new FormControl('', [
Validators.required
// Validators.email,
]);

getErrorMessage() {
return this.formControl.hasError('required') ? 'Required field' :
this.formControl.hasError('email') ? 'Not a valid email' :
'';
}

submit() {
// emppty stuff
}

onNoClick(): void {
this.dialogRef.close();
}

public confirmAdd(): void {
this.dataService.addBook(this.book);


this.dataService.addBook(this.book).subscribe(res=>  
  {  
    alert("Data added successfully !! ")  
  })  
  ,err=>  
  {  
    console.log("Error Occured " + err);  
  }  
}

}
