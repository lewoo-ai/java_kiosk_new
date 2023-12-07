import {Component, Input, OnInit} from '@angular/core';

@Component({
    selector: 'app-pagination',
    templateUrl: './pagination.html',
    styleUrls: ['./pagination.css']
})
export class PaginationComponent implements OnInit {

    @Input() currentPage: any;

    constructor() {
    }

    ngOnInit() {
    }

    counter(i = 1) {
        return new Array(i);
    }
}
