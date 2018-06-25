import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule, MatIconModule, MatToolbarModule, MatInputModule, MatPaginatorModule, MatProgressSpinnerModule, MatSortModule, MatTableModule, MatDialogModule, MatSelectModule } from '@angular/material';

@NgModule({
  imports: [MatButtonModule, MatIconModule, MatToolbarModule, MatInputModule, MatPaginatorModule, MatProgressSpinnerModule, MatSortModule, MatTableModule, MatDialogModule, MatSelectModule],
  exports: [MatButtonModule, MatIconModule, MatToolbarModule, MatInputModule, MatPaginatorModule, MatProgressSpinnerModule, MatSortModule, MatTableModule, MatDialogModule, MatSelectModule]
})
export class MaterialModule { }