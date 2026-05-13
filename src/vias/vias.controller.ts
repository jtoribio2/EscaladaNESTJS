import {
    Controller,
    Get,
    Post,
    Body,
    Query,
} from '@nestjs/common';

import { Param } from '@nestjs/common';

import { ViasService } from './vias.service';

import { CreateViaDto } from './dto/create-via.dto';
import { FilterViaDto } from './dto/filter-via.dto';


@Controller('vias')
export class ViasController {

    constructor(
        private readonly viasService: ViasService,
    ) { }

    @Get()
    findAll(
        @Query() filters: FilterViaDto,
    ) {
        return this.viasService.findAll(filters);
    }

    @Get(':id')
    findOne(
        @Param('id') id: string,
    ) {
        return this.viasService.findOne(Number(id));
    }

    @Post()
    create(@Body() createViaDto: CreateViaDto) {
        return this.viasService.create(createViaDto);
    }
}