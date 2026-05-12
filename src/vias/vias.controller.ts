import { Controller, Get } from '@nestjs/common';
import { ViasService } from './vias.service';
import { Body, Post } from '@nestjs/common';
import { CreateViaDto } from './dto/create-via.dto';

@Controller('vias')
export class ViasController {

    constructor(
        private readonly viasService: ViasService,
    ) { }

    @Get()
    findAll() {
        return this.viasService.findAll();
    }

    @Post()
    create(@Body() createViaDto: CreateViaDto) {
        return this.viasService.create(createViaDto);
    }
}